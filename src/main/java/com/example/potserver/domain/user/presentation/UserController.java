package com.example.potserver.domain.user.presentation;

import com.example.potserver.domain.user.presentation.dto.request.SignupRequest;
import com.example.potserver.domain.user.service.LoginService;
import com.example.potserver.domain.user.service.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final SignupService signupService;
    private final LoginService loginService;

    @PostMapping("/signup")
    public void signup(@RequestBody SignupRequest request) {
        signupService.signup(request);
    }


    @PostMapping("/login")
    public void login(@RequestBody SignupRequest request) {
        loginService.login(request);
    }

}
