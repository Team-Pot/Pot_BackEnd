package com.example.potserver.global.exception.user;

import com.example.potserver.global.error.exception.BusinessException;
import com.example.potserver.global.error.exception.ErrorCode;

public class AlreadyDisLikeException extends BusinessException {

    public static final BusinessException EXCEPTION = new AlreadyDisLikeException();

    public AlreadyDisLikeException() {
        super(ErrorCode.ALREADY_DISLIKE);
    }
}