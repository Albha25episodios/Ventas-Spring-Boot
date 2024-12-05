package com.episodios.cascaparomarket.services;

import com.episodios.cascaparomarket.config.ApplicationConfig;
import com.episodios.cascaparomarket.dtos.TokenResponseDTO;
import com.episodios.cascaparomarket.dtos.LoginRequestDTO;
import com.episodios.cascaparomarket.dtos.RegisterRequestDTO;
import com.episodios.cascaparomarket.models.Role;
import com.episodios.cascaparomarket.models.Token;
import com.episodios.cascaparomarket.models.User;
import com.episodios.cascaparomarket.repositories.TokenRepository;
import com.episodios.cascaparomarket.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public TokenResponseDTO register(RegisterRequestDTO registerRequestDTO) {
        User user = User.builder()
                .name(registerRequestDTO.getUserName())
                .email(registerRequestDTO.getUserEmail())
                .password(passwordEncoder.encode(registerRequestDTO.getUserPassword()))
                .role(Role.USER)
                .build();

        var savedUser = userRepository.save(user);
        var savedToken = jwtService.getToken(user);
        saveUserToken(savedUser, savedToken);
        return TokenResponseDTO.builder()
                .token(savedToken)
                .build();
    }

    public TokenResponseDTO login(LoginRequestDTO loginRequestDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestDTO.getEmail(),
                        loginRequestDTO.getPassword()
                )
        );
        var user = userRepository.findByEmail(loginRequestDTO.getEmail()).orElseThrow();
        System.out.println(user);
        revokeAllUserTokens(user);
        var savedToken = jwtService.getToken(user);
        saveUserToken(user, savedToken);
        return TokenResponseDTO.builder()
                .token(jwtService.getToken(user))
                .build();
    }

    private void revokeAllUserTokens(User user) {
        List<Token> validateUserTokens = tokenRepository.findAllByUserIdAndExpiredFalseAndRevokedFalse(user.getId());
        if (!validateUserTokens.isEmpty()) {
            for (Token token : validateUserTokens) {
                token.setExpired(true);
                token.setRevoked(true);
            }
            tokenRepository.saveAll(validateUserTokens);
        }
    }

    private void saveUserToken(User user, String jwtToken) {
        tokenRepository.save(
                Token.builder().user(user)
                        .token(jwtToken)
                        .tokenType(Token.TokenType.BEARER)
                        .expired(false)
                        .revoked(false)
                        .build());
    }

}
