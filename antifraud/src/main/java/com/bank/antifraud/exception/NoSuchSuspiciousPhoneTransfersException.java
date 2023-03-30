package com.bank.antifraud.exception;

public class NoSuchSuspiciousPhoneTransfersException extends RuntimeException {
    public NoSuchSuspiciousPhoneTransfersException(String message) {
        super(message);
    }
}
