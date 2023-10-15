package com.example.potserver.domain.user.presentation;

import com.example.potserver.domain.user.presentation.dto.request.CheckEmailRequest;
import com.example.potserver.domain.user.presentation.dto.request.SendEmailRequest;
import com.example.potserver.domain.user.presentation.dto.response.EmailVerificationResult;
import com.example.potserver.domain.user.presentation.dto.response.SingleResponseDto;
import com.example.potserver.domain.user.service.CheckCodeService;
import com.example.potserver.domain.user.service.SendCodeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final SendCodeService sendCodeService;
    private final CheckCodeService checkCodeService;

    @PostMapping("/emails")
    public void sendMessage(@RequestBody @Valid SendEmailRequest request) {
        sendCodeService.sendCodeToEmail(request.getEmail());
    }

    @GetMapping("/emails")
    public boolean verificationEmail(@RequestBody @Valid CheckEmailRequest request) {
        return checkCodeService.checkCode(request.getEmail(), request.getCode());
    }

}