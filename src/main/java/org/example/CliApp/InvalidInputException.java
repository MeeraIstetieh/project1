package org.example.CliApp;

public class InvalidInputException extends Exception {
    public InvalidInputException() {
        super("Invalid Input");
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
