package com.example.potserver.domain.auth.service;

import com.example.potserver.domain.user.entity.User;
import com.example.potserver.domain.auth.presentation.dto.request.SignupRequest;
import com.example.potserver.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignupService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signup(SignupRequest request) {
        String password = passwordEncoder.encode(request.getPassword());

        userRepository.save(
                User.builder()
                        .userId(request.getUserId())
                        .password(password)
                        .build());
    }

}
