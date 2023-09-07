package com.example.potserver.domain.auth.repository;

import com.example.potserver.domain.auth.repository.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
}
