package edu.captech.cs225.tio;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ExceptionExample {

    /**
     * Main entry point for the application. Please feel free to comment out each
     * line to test each example in isolation.
     */
    public static void main(String[] args) throws IOException {
        unitTestException();
        iterator();
        readNextRecord();
    }

    public static void readNextRecord() throws IOException {
        try {
            readFile();
        } catch (IOException e) {
            throw new IOException("Unable to read next record", e);
        }
    }

    public static void readFile() throws IOException {
        try {
            readLine();
        } catch (IOException e) {
            throw new IOException("Unable to read file", e);
        }
    }

    public static void readLine() throws IOException {
        throw new IOException("Unable to read line. Invalid format.");
    }

    /**
     * Example of writing a unit test for an exception. This test expects that the
     * {@link #readNextRecord()} will throw an Exception. Therefore, the SOP is
     * skipped. If this method does not throw an Exception (incorrectly) then the
     * test will fail and the test message printed.
     */
    public static void unitTestException() {
        try {
            readNextRecord();
            System.out.println("Expected to throw an Exception and it did not");
        } catch (IOException e) {
            // Ignore
        }
    }

    public static void iterator() {
        List<String> list = Arrays.asList("A", "B", "C", "D");
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            String next = iter.next();
            System.out.println(next);
        }
    }
}
