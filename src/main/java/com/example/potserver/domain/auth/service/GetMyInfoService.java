package com.example.potserver.domain.auth.service;

import com.example.potserver.domain.user.entity.User;
import com.example.potserver.domain.user.facade.UserFacade;
import com.example.potserver.domain.auth.presentation.dto.response.MyInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetMyInfoService {

    private final UserFacade userFacade;

    public MyInfoResponse getMyInfo() {
        User user = userFacade.currentUser();

        return new MyInfoResponse(user);
    }
}
