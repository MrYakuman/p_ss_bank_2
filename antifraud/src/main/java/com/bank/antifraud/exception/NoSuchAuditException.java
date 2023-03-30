package com.bank.antifraud.exception;

public class NoSuchAuditException extends RuntimeException {
    public NoSuchAuditException(String message) {
        super(message);
    }
}
