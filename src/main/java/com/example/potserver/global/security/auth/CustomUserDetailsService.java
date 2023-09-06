package com.example.potserver.global.security.auth;

import com.example.potserver.domain.user.entity.User;
import com.example.potserver.domain.user.repository.UserRepository;
import com.example.potserver.global.exception.user.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) {

        User user = userRepository.findByUserId(userName)
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);

        return new CustomUserDetails(user);
    }

}