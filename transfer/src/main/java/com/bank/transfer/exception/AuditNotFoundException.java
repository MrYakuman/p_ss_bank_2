package com.bank.transfer.exception;

public class AuditNotFoundException extends RuntimeException{
    public AuditNotFoundException(String message) {
        super(message);
    }
}
