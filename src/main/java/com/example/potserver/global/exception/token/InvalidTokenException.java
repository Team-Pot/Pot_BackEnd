package com.example.potserver.global.exception.token;

import com.example.potserver.global.error.exception.BusinessException;
import com.example.potserver.global.error.exception.ErrorCode;

public class InvalidTokenException extends BusinessException {

    public static final BusinessException EXCEPTION = new InvalidTokenException();

    public InvalidTokenException(){
        super(ErrorCode.INVALID_TOKEN);
    }

}
