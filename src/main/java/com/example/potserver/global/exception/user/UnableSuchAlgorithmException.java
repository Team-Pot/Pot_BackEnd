package com.example.potserver.global.exception.user;

import com.example.potserver.global.error.exception.BusinessException;
import com.example.potserver.global.error.exception.ErrorCode;

public class UnableSuchAlgorithmException extends BusinessException {
    public static final BusinessException EXCEPTION = new UnableSuchAlgorithmException();

    public UnableSuchAlgorithmException() {
        super(ErrorCode.NO_SUCH_ALGORITHM);
    }

}