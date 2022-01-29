package edu.captech.cs225.tio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.function.Consumer;

public class StockCsvParser  <String > extends AbstractCsvParser{

    public StockCsvParser(File file) throws FileNotFoundException {
        super(file);
    }
    public StockCsvParser(String ticker, File file) throws FileNotFoundException {
        super(file);
        try {
            if(ticker == null)
                throw new NullPointerException();
        }catch (NullPointerException ex){
            System.out.println(ex);
        }
        try {
            if(file == null){
                throw new NullPointerException();
            }
        }catch (NullPointerException ex2){
            System.out.println(ex2);
        }
        try {
            if(!file.exists())
                throw new FileNotFoundException();
        }catch (FileNotFoundException noFileFound){
            System.out.println(noFileFound);
        }
        }

    @Override
    protected Object handleElements(java.lang.String[] elements) throws CsvParsingException{
        //correct column = (Date,Open,High,Low,Close,Adj Close,Volume)
        StockQuote qoutes = new StockQuote();
        if (elements.length != 7)
            throw new StockCsvParsingException("Expected 7. Get : " + elements.length);
        //while(elements.length > 0){
           // int i = 0;

        /// convert to Float & Int
        /// set to each component variables
        try {
            qoutes.setDate(elements[0]);


        }
        catch (StockCsvParsingException wrongNum){
            System.out.println("Unparsable Value: ");
        }
        try {
            qoutes.setOpen(Float.parseFloat(elements[1]));
        }
        catch (StockCsvParsingException wrongNum){
            System.out.println("Unparsable Value: ");
        }
        try {
            qoutes.setHigh(Float.parseFloat(elements[2]));



        }
        catch (StockCsvParsingException wrongNum){
            System.out.println("Unparsable Value: ");
        }
        try {
            qoutes.setLow(Float.parseFloat(elements[3]));



        }
        catch (StockCsvParsingException wrongNum){
            System.out.println("Unparsable Value: ");
        }
        try {
            qoutes.setClose(Float.parseFloat(elements[4]));
        }
        catch (StockCsvParsingException wrongNum){
            System.out.println(wrongNum);
        }
        try {
            qoutes.setAdjClose(Float.parseFloat(elements[5]));

        }
        catch (StockCsvParsingException wrongNum){
            System.out.println("Unparsable Value: ");
        }
        try {
            qoutes.setVolume(Integer.parseInt(elements[6]));

        }
        catch (StockCsvParsingException wrongNum){
            System.out.println("Unparsable Value: ");
        }



        return qoutes;

    };

    }