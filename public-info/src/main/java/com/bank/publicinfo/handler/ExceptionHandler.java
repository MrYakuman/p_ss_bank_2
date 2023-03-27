package com.bank.publicinfo.handler;

import lombok.Data;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
@Data
public class ExceptionHandler extends RuntimeException{

}
