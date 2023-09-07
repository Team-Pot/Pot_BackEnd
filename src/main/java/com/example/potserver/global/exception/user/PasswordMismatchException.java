package com.example.potserver.global.exception.user;

import com.example.potserver.global.error.exception.BusinessException;
import com.example.potserver.global.error.exception.ErrorCode;

public class PasswordMismatchException extends BusinessException {

    public static final BusinessException EXCEPTION = new PasswordMismatchException();

    public PasswordMismatchException() {
        super(ErrorCode.PASSWORD_MISMATCH);
    }

}
