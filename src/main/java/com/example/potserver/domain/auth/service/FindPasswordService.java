package com.example.potserver.domain.auth.service;

import com.example.potserver.domain.auth.presentation.dto.request.FindPasswordRequest;
import com.example.potserver.domain.auth.presentation.dto.response.PasswordResponse;
import com.example.potserver.domain.user.entity.User;
import com.example.potserver.domain.user.facade.UserFacade;
import com.example.potserver.domain.user.service.CheckCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindPasswordService {

    private final UserFacade userFacade;
    private final CheckCodeService checkCodeService;

    public PasswordResponse findPassword(FindPasswordRequest request) {
        User user = userFacade.currentUser();

        if(checkCodeService.checkCode(request.getEmail(), request.getCode())) {
            return new PasswordResponse(user);
        }

        return new PasswordResponse();
    }
}
