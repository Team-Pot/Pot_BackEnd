package com.example.potserver.domain.user.presentation.dto.response;

import lombok.Getter;

@Getter
public class SingleResponseDto<T> {
    private T data;
    private String message;

    public SingleResponseDto(T data) {
        this.data = data;
        this.message = "success";
    }

    public SingleResponseDto(T data, String message) {
        this.data = data;
        this.message = message;
    }

}
