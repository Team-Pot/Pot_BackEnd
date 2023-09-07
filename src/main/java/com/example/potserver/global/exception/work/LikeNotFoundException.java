package com.example.potserver.global.exception.work;

import com.example.potserver.global.error.exception.BusinessException;
import com.example.potserver.global.error.exception.ErrorCode;

public class LikeNotFoundException extends BusinessException {

    public static final BusinessException EXCEPTION = new LikeNotFoundException();

    public LikeNotFoundException() {
        super(ErrorCode.LIKE_NOT_FOUND);
    }

}
