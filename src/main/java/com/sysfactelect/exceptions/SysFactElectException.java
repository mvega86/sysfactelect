package com.sysfactelect.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class SysFactElectException extends RuntimeException{

    private String message;
    private HttpStatus httpStatus;


    public SysFactElectException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
