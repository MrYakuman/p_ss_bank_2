package com.bank.publicinfo.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
@Data
public class NotFoundExceptionHandler extends RuntimeException {
    private String message;
}
