package com.example.potserver.domain.user.service;

import com.example.potserver.domain.auth.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class SendCodeService {

    private static final String AUTH_CODE_PREFIX = "AuthCode ";
    private final RedisService redisService;
    private final MailService mailService;
    private final CheckDuplicatedEmail checkDuplicatedEmail;
    private final CreateCode createCode;
    @Value("${spring.mail.auth-code-expiration-millis}")
    private long authCodeExpirationMillis;

    @Async
    public void sendCodeToEmail(String toEmail) {
        checkDuplicatedEmail.checkDuplicatedEmail(toEmail);

        String title = "Travel with me 이메일 인증 번호";
        String authCode = createCode.createCode();
        mailService.sendEmail(toEmail, title, authCode);
        // 이메일 인증 요청 시 인증 번호 Redis에 저장 ( key = "AuthCode " + Email / value = AuthCode )
        redisService.setValues(AUTH_CODE_PREFIX + toEmail,
                authCode, Duration.ofMillis(this.authCodeExpirationMillis));
    }

}
