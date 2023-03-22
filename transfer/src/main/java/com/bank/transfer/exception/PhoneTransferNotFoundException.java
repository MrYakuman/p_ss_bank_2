package com.bank.transfer.exception;

public class PhoneTransferNotFoundException extends RuntimeException {
    public PhoneTransferNotFoundException() {
    }

    public PhoneTransferNotFoundException(String message) {
        super(message);
    }
}
