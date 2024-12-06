package com.episodios.cascaparomarket.repositories;

import com.episodios.cascaparomarket.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {
    List<Token> findAllByUserIdAndExpiredFalseAndRevokedFalse(Long user_id);

    Token findByToken (String token);
}
