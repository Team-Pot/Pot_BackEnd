package com.example.potserver.domain.user.presentation.dto.response;

import com.example.potserver.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MyInfoResponse {

    private String userId;

    public MyInfoResponse(User user) {
        userId = user.getUserId();
    }
}
