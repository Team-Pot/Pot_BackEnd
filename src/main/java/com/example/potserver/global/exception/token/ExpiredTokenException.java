package com.example.potserver.global.exception.token;

import com.example.potserver.global.error.exception.BusinessException;
import com.example.potserver.global.error.exception.ErrorCode;

public class ExpiredTokenException extends BusinessException {

    public static final BusinessException EXCEPTION = new ExpiredTokenException();

    public ExpiredTokenException(){
        super(ErrorCode.EXPIRED_TOKEN);
    }

}