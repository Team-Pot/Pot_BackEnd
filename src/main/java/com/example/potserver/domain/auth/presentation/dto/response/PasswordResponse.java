package com.example.potserver.domain.auth.presentation.dto.response;

import com.example.potserver.domain.user.entity.User;
import com.example.potserver.global.exception.user.UserNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PasswordResponse {
    private String password;

    public PasswordResponse(User user) {
        password = user.getPassword();
    }

    public PasswordResponse() {
        throw UserNotFoundException.EXCEPTION;
    }
}
