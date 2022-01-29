package edu.captech.cs225.tio;

import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class TestStockCsvParser {
    public static void main(String[] args) throws FileNotFoundException {

        testWorkingFIle();
        testNpeTicker();
        testNpeFile();
        testFileNotFound();
        testBrokenFile();
        System.out.println("Unparsable ");
        testUnParsableFile();

    }
    public static void testWorkingFIle(){
        double lowestPrice = 9.34;
        double highestPrice = 19.35;
        double averageVolume = 5275629;



        //initialize mylow with a sample number because everything will be bigger than 0;
        double myLow =11.850000; // quote low at index[0]
        double myHigh = 0.0;
        double totalV = 0.0;
        int amount = 0;



        StockQuote quote = new StockQuote();

        try{
            StockCsvParser csvParser = new StockCsvParser(new File("C:\\Users\\biakh\\Downloads\\assignment\\CLDR.csv"));

            do {
                quote = (StockQuote) csvParser.next();
                totalV += quote.getVolume();
                amount++;
                System.out.println(quote.getLow() + "," + quote.getHigh());
                if(myLow >= quote.getLow()){
                    System.out.println("THis is in if: Low " + myLow + "before assin: " + quote.getLow());
                    myLow = quote.getLow();
                    System.out.println("THis is in if: highhh " + myLow + "before assin: " + quote.getHigh());
                }
                if(myHigh <= quote.getHigh())
                    myHigh = quote.getHigh();

            }while (csvParser.hasNext());


        } catch (FileNotFoundException foundException) {
            foundException.printStackTrace();
        }


          //testing for lowest
        if( myLow != lowestPrice)
            System.out.println("Expected Lowest Price:  " + lowestPrice + " but get "+ myLow);
        if(myHigh!= highestPrice)
            System.out.println("Expected Highest Price:  " + highestPrice + " but get "+ myHigh);
        if(totalV/amount != averageVolume)
            System.out.println("Expected Average Volume:  " + averageVolume + " but get "+ totalV/amount);

        System.out.println();
//        System.out.println("my low"+ myLow);
//        System.out.println("myH"+ myHigh);
        System.out.println();
    }
    public static void testNpeFile() throws FileNotFoundException {
        System.out.println("THis is NPE mull File testing");
        try {
            StockCsvParser csvParser = new StockCsvParser("Hello", null);
        } catch (NullPointerException ex){
            System.out.println(ex);
        }
    }
    public static void testNpeTicker() throws FileNotFoundException {
        System.out.println("THis is NPE Tickere testing");
        try {
            StockCsvParser csvParser = new StockCsvParser(null);
        } catch (NullPointerException ex){
            System.out.println(ex);
        }
    }
    public static void testFileNotFound(){
        System.out.println("Testing for FIle Not Found");

        try{
            StockCsvParser csvParser = new StockCsvParser(new File("thisIsInvalidFile.txt"));

        } catch (FileNotFoundException notFoundException) {
            System.out.println(notFoundException);
        }

    }
    public static void testBrokenFile(){
        try {
            StockCsvParser csvParser = new StockCsvParser(new File("C:\\Users\\biakh\\Downloads\\assignment\\CLDR.broken.csv"));
            throw new CsvParsingException("This FIle is a Broken file");
        } catch (CsvParsingException ex) {
            System.out.println(ex);
        } catch (FileNotFoundException notFoundException) {
            notFoundException.printStackTrace();
        }
    }
    public static void testUnParsableFile() throws FileNotFoundException {
        StockQuote quote = new StockQuote();

            StockCsvParser csvParser = new StockCsvParser(new File("C:\\Users\\biakh\\Downloads\\assignment\\myCsvFile.csv"));

    }}
