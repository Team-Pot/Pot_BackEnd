package com.example.potserver.domain.auth.service;

import com.example.potserver.domain.auth.presentation.dto.request.LoginRequest;
import com.example.potserver.domain.auth.presentation.dto.request.SignupRequest;
import com.example.potserver.domain.auth.presentation.dto.response.TokenResponse;
import com.example.potserver.domain.user.entity.User;
import com.example.potserver.domain.user.repository.UserRepository;
import com.example.potserver.global.exception.user.PasswordMismatchException;
import com.example.potserver.global.exception.user.UserNotFoundException;
import com.example.potserver.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    public TokenResponse login(LoginRequest request) {
        User user = userRepository.findByUserId(request.getUserId())
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        }

        return jwtTokenProvider.createToken(request.getUserId());
    }

}
