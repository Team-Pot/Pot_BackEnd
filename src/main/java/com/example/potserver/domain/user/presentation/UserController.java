package com.example.potserver.domain.user.presentation;

import com.example.potserver.domain.user.presentation.dto.request.SignupRequest;
import com.example.potserver.domain.auth.presentation.dto.response.TokenResponse;
import com.example.potserver.domain.user.presentation.dto.response.MyInfoResponse;
import com.example.potserver.domain.user.service.GetMyInfoService;
import com.example.potserver.domain.user.service.LoginService;
import com.example.potserver.domain.user.service.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final SignupService signupService;
    private final LoginService loginService;
    private final GetMyInfoService getMyInfoService;

    @PostMapping("/signup")
    public void signup(@RequestBody SignupRequest request) {
        signupService.signup(request);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody SignupRequest request) {
        return loginService.login(request);
    }

    @GetMapping("/user")
    public MyInfoResponse getMyInfo() {
        return getMyInfoService.getMyInfo();
    }

}
