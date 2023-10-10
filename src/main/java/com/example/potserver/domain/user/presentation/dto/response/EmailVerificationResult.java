package com.example.potserver.domain.user.presentation.dto.response;

import lombok.Getter;

@Getter
public class EmailVerificationResult {
    private boolean verificationSuccess;

    private EmailVerificationResult(boolean verificationSuccess) {
        this.verificationSuccess = verificationSuccess;
    }

    public static EmailVerificationResult of(boolean verificationSuccess) {
        return new EmailVerificationResult(verificationSuccess);
    }

}