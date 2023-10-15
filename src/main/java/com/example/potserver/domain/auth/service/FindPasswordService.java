package com.example.potserver.domain.auth.service;

import com.example.potserver.domain.auth.presentation.dto.request.FindPasswordRequest;
import com.example.potserver.domain.user.entity.User;
import com.example.potserver.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindPasswordService {
    private final UserFacade userFacade;

    public void findPassword(FindPasswordRequest request) {
        User user = userFacade.currentUser();

        user.changePassword(request.getPassword());
    }
}
