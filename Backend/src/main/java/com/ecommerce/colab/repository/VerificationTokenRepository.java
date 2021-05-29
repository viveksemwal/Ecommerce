package com.ecommerce.colab.repository;

import com.ecommerce.colab.model.VerificationToken;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken,Integer> {

    public Optional<VerificationToken> findByToken(String token);
}
