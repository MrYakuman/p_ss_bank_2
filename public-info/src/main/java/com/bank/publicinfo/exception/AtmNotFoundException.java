package com.bank.publicinfo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AtmNotFoundException extends RuntimeException{

    private String message;
}
