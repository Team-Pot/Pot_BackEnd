package com.example.potserver.domain.auth.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FindPasswordRequest {
    private String email;
    private String code;
}
