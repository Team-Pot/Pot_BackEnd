package com.example.potserver.domain.user.facade;

import com.example.potserver.domain.user.entity.User;
import com.example.potserver.domain.user.repository.UserRepository;
import com.example.potserver.global.exception.user.NotAuthenticatedException;
import com.example.potserver.global.exception.user.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository userRepository;

    public User currentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            throw new NotAuthenticatedException("인증되지 않는 사용자입니다.");
        }

        String userId = authentication.getName();

        return userRepository.findByUserId(userId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

}
