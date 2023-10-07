package com.example.potserver.domain.auth.service;

import com.example.potserver.domain.auth.presentation.dto.response.TokenResponse;
import com.example.potserver.domain.user.entity.User;
import com.example.potserver.domain.auth.presentation.dto.request.SignupRequest;
import com.example.potserver.domain.user.repository.UserRepository;
import com.example.potserver.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignupService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public TokenResponse signup(SignupRequest request) {
        String password = passwordEncoder.encode(request.getPassword());

        userRepository.save(
                User.builder()
                        .userId(request.getUserId())
                        .password(password)
                        .build());

        return jwtTokenProvider.createToken(request.getUserId());
    }

}
