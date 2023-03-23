package com.bank.account.handler;

import com.bank.account.exception.NoSuchInfoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class InfoExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<IncorrectData> handleException(NoSuchInfoException e) {
        var incorrectData = new IncorrectData();
        incorrectData.setInfo(e.getMessage());
        return new ResponseEntity<>(incorrectData, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<IncorrectData> handleException(Exception e) {
        var incorrectData = new IncorrectData();
        incorrectData.setInfo(e.getMessage());
        return new ResponseEntity<>(incorrectData, HttpStatus.BAD_REQUEST);
    }
}
