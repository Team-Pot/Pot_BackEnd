package com.example.potserver.domain.user.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CheckEmailRequest {
    private String email;
    private String code;
}
