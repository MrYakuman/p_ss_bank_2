package com.bank.antifraud.exception;

public class NoSuchSuspiciousAccountTransfersException extends RuntimeException {
    public NoSuchSuspiciousAccountTransfersException(String message) {
        super(message);
    }
}
