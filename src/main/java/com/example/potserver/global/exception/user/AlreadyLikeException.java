package com.example.potserver.global.exception.user;

import com.example.potserver.global.error.exception.BusinessException;
import com.example.potserver.global.error.exception.ErrorCode;

public class AlreadyLikeException extends BusinessException {

    public static final BusinessException EXCEPTION = new AlreadyLikeException();

    public AlreadyLikeException() {
        super(ErrorCode.ALREADY_LIKE);
    }
}