package com.bank.publicinfo.handler;

import com.bank.publicinfo.exception.AtmNotFoundException;
import com.bank.publicinfo.exception.BankDetailsNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<NotFoundExceptionHandler> responseEntity(AtmNotFoundException e) {
        NotFoundExceptionHandler notFoundExceptionHandler = new NotFoundExceptionHandler();
        notFoundExceptionHandler.setMessage(e.getMessage());
        return new ResponseEntity<>(notFoundExceptionHandler, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<NotFoundExceptionHandler> responseEntity(BankDetailsNotFoundException e) {
        NotFoundExceptionHandler notFoundExceptionHandler = new NotFoundExceptionHandler();
        notFoundExceptionHandler.setMessage(e.getMessage());
        return new ResponseEntity<>(notFoundExceptionHandler, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<NotFoundExceptionHandler> responseEntity(Exception e) {
        NotFoundExceptionHandler notFoundExceptionHandler = new NotFoundExceptionHandler();
        notFoundExceptionHandler.setMessage(e.getMessage());
        return new ResponseEntity<>(notFoundExceptionHandler,HttpStatus.BAD_REQUEST);
    }
}
