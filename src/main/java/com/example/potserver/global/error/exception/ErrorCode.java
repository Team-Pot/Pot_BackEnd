package com.example.potserver.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    // jwt
    EXPIRED_TOKEN(401 , "Expired token"),
    INVALID_TOKEN(401, "Invalid token"),

    //user
    USER_NOT_FOUND(404, "User not found"),
    PASSWORD_MISMATCH(403, "Password mismatch"),
    USER_EXISTS(403, "User exists"),
    UNABLE_SEND_EMAIL(500, "Unable to send email"),
    NO_SUCH_ALGORITHM(500, "No such algorithm"),

    // general
    BAD_REQUEST(400, "Bad request"),
    INTERNAL_SERVER_ERROR(500, "Internal server error");

    private final int statusCode;
    private final String message;

}
