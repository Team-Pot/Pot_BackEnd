package com.example.potserver.domain.user.service;

import com.example.potserver.domain.auth.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckCodeService {

    private static final String AUTH_CODE_PREFIX = "AuthCode ";
    private final RedisService redisService;
    private final CheckDuplicatedEmail checkDuplicatedEmail;

    public boolean checkCode(String email, String authCode) {
        checkDuplicatedEmail.checkDuplicatedEmail(email);
        String redisAuthCode = redisService.getValues(AUTH_CODE_PREFIX + email);
        return redisService.checkExistsValue(redisAuthCode) && redisAuthCode.equals(authCode);
    }

}
