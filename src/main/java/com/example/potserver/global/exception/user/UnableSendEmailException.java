package com.example.potserver.global.exception.user;

import com.example.potserver.global.error.exception.BusinessException;
import com.example.potserver.global.error.exception.ErrorCode;

public class UnableSendEmailException extends BusinessException {

    public static final BusinessException EXCEPTION = new UnableSendEmailException();

    public UnableSendEmailException() {
        super(ErrorCode.UNABLE_SEND_EMAIL);
    }

}
