package com.example.potserver.global.exception.user;

import com.example.potserver.global.error.exception.BusinessException;
import com.example.potserver.global.error.exception.ErrorCode;

public class UserExistsException extends BusinessException {
    public static final BusinessException EXCEPTION = new UserExistsException();

    public UserExistsException() {
        super(ErrorCode.USER_NOT_FOUND);
    }

}


