package com.bank.account.exception;

public class NoSuchInfoException extends RuntimeException {
    public NoSuchInfoException(String message) {
        super(message);
    }
}
