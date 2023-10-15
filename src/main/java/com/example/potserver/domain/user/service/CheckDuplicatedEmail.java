package com.example.potserver.domain.user.service;

import com.example.potserver.domain.user.entity.User;
import com.example.potserver.domain.user.repository.UserRepository;
import com.example.potserver.global.exception.user.EmailExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CheckDuplicatedEmail {
    private final UserRepository userRepository;

    public void checkDuplicatedEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent()) {
            throw EmailExistsException.EXCEPTION;
        }
    }
}