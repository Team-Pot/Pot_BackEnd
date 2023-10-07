package com.example.potserver.domain.auth.service;

import com.example.potserver.domain.user.entity.User;
import com.example.potserver.domain.auth.presentation.dto.request.SignupRequest;
import com.example.potserver.domain.auth.presentation.dto.response.TokenResponse;
import com.example.potserver.domain.user.repository.UserRepository;
import com.example.potserver.global.exception.user.PasswordMismatchException;
import com.example.potserver.global.exception.user.UserNotFoundException;
import com.example.potserver.global.security.jwt.JwtProperties;
import com.example.potserver.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtProperties jwtProperties;
    private final PasswordEncoder passwordEncoder;

    public TokenResponse login(SignupRequest request) {
        Date now = new Date();

        User user = userRepository.findByUserId(request.getUserId())
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        }

        return TokenResponse.builder()
                .refreshToken(jwtTokenProvider.createRefreshToken(user.getUserId()))
                .accessToken(jwtTokenProvider.createAccessToken(user.getUserId()))
                .accessExpiredAt(new Date(now.getTime() + jwtProperties.getAccessExpiration()))
                .refreshExpiredAt(new Date(now.getTime() + jwtProperties.getRefreshExpiration()))
                .build();
    }
}
