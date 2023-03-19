package com.bank.history.Exceptions;

public class HistoryNotFoundException extends RuntimeException{
    public HistoryNotFoundException(String message) {
        super(message);
    }
}
