package com.example.potserver.domain.auth.repository;

import com.example.potserver.domain.auth.repository.entity.RefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, Long> {
}
