package com.example.potserver.domain.user.presentation;

import com.example.potserver.domain.user.presentation.dto.request.CheckEmailRequest;
import com.example.potserver.domain.user.presentation.dto.request.SendEmailRequest;
import com.example.potserver.domain.user.presentation.dto.response.EmailVerificationResult;
import com.example.potserver.domain.user.presentation.dto.response.SingleResponseDto;
import com.example.potserver.domain.user.service.UserService;
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

    private final UserService userService;

    @PostMapping("/emails")
    public ResponseEntity sendMessage(@RequestBody @Valid SendEmailRequest request) {
        userService.sendCodeToEmail(request.getEmail());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/emails")
    public ResponseEntity verificationEmail(@RequestBody @Valid CheckEmailRequest request) {
        EmailVerificationResult response = userService.verifiedCode(request.getEmail(), request.getCode());

        return new ResponseEntity<>(new SingleResponseDto<>(response), HttpStatus.OK);
    }

}