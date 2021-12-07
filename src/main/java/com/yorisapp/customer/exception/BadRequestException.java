package com.yorisapp.customer.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException{
    @Getter
    private String code;

    public BadRequestException(String pCode){
        super("Bad Request");
        this.code = pCode;
    }

    public BadRequestException(String pCode, String pMessage){
        super(pMessage);
        this.code = pCode;
    }
}