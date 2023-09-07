package com.example.potserver.global.exception.work;

import com.example.potserver.global.error.exception.BusinessException;
import com.example.potserver.global.error.exception.ErrorCode;

public class CommentNotFoundException extends BusinessException {

    public static final BusinessException EXCEPTION = new CommentNotFoundException();

    public CommentNotFoundException() {
        super(ErrorCode.COMMENT_NOT_FOUND);
    }

}