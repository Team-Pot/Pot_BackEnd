package com.example.potserver.global.exception.work;

import com.example.potserver.global.error.exception.BusinessException;
import com.example.potserver.global.error.exception.ErrorCode;

public class DisLikeNotFoundException extends BusinessException {

    public static final BusinessException EXCEPTION = new DisLikeNotFoundException();

    public DisLikeNotFoundException() {
        super(ErrorCode.DIS_LIKE_NOT_FOUND);
    }

}