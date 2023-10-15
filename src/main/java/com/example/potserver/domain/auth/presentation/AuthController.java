package com.example.potserver.domain.auth.presentation;

import com.example.potserver.domain.auth.presentation.dto.request.FindPasswordRequest;
import com.example.potserver.domain.auth.presentation.dto.request.LoginRequest;
import com.example.potserver.domain.auth.presentation.dto.request.SignupRequest;
import com.example.potserver.domain.auth.presentation.dto.response.MyInfoResponse;
import com.example.potserver.domain.auth.presentation.dto.response.TokenResponse;
import com.example.potserver.domain.auth.service.FindPasswordService;
import com.example.potserver.domain.auth.service.GetMyInfoService;
import com.example.potserver.domain.auth.service.LoginService;
import com.example.potserver.domain.auth.service.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final SignupService signupService;
    private final LoginService loginService;
    private final GetMyInfoService getMyInfoService;
    private final FindPasswordService findPasswordService;

    @PostMapping("/signup")
    public TokenResponse signup(@RequestBody @Valid SignupRequest request) {
        return signupService.signup(request);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid LoginRequest request) {
        return loginService.login(request);
    }

    @GetMapping("/my-info")
    public MyInfoResponse getMyInfo() {
        return getMyInfoService.getMyInfo();
    }

    @GetMapping("/find-password")
    public void findPassword(@RequestBody @Valid FindPasswordRequest request) {
        findPasswordService.findPassword(request);
    }

}
