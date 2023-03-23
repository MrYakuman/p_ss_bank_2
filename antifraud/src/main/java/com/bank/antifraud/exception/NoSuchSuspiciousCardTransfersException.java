package com.bank.antifraud.exception;

public class NoSuchSuspiciousCardTransfersException extends RuntimeException {
    public NoSuchSuspiciousCardTransfersException(String message) {
        super(message);
    }
}
