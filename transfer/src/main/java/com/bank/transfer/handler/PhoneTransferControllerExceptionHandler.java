package com.bank.transfer.handler;

import com.bank.transfer.exception.PhoneTransferException;
import com.bank.transfer.exception.PhoneTransferNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class PhoneTransferControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PhoneTransferNotFoundException.class)
    public ResponseEntity<String> handlePhoneTransferNotFoundException(PhoneTransferNotFoundException e) {
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PhoneTransferException.class)
    public ResponseEntity<String> handleCardTransferException(PhoneTransferException e) {
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
