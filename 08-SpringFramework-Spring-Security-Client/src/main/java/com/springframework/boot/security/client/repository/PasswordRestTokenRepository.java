package com.springframework.boot.security.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springframework.boot.security.client.entity.PasswordResetToken;

@Repository
public interface PasswordRestTokenRepository extends JpaRepository<PasswordResetToken, Long>{

	PasswordResetToken findByToken(String token);

}
