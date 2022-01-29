package edu.captech.cs225.tio;

public class StockCsvParsingException extends CsvParsingException{
    public StockCsvParsingException(String message) {
        super(message);
    }

    public StockCsvParsingException(String message, Throwable cause) {
        super(message, cause);
    }
    public StockCsvParsingException(String ticker, String message, Throwable cause){
        super(ticker);
    }

}
