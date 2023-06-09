package com.bank.profile.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String className, Long id) {
        super(String.format("%s(s) with id = %s not found", className, id));
    }
    public EntityNotFoundException(String className, Long id, RuntimeException e) {
        super(String.format("%s(s) with id = %s not found", className, id), e);
    }

    public EntityNotFoundException(String className) {
        super(String.format("%s(s) not found", className));
    }
}
