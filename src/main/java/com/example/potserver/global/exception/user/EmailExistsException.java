package com.example.potserver.global.exception.user;

import com.example.potserver.global.error.exception.BusinessException;
import com.example.potserver.global.error.exception.ErrorCode;

public class EmailExistsException extends BusinessException {
    public static final BusinessException EXCEPTION = new EmailExistsException();

    public EmailExistsException() {
        super(ErrorCode.PASSWORD_MISMATCH);
    }

}