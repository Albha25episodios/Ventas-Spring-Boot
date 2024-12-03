package com.episodios.cascaparomarket.services;

import com.episodios.cascaparomarket.config.ApplicationConfig;
import com.episodios.cascaparomarket.dtos.TokenResponseDTO;
import com.episodios.cascaparomarket.dtos.LoginRequestDTO;
import com.episodios.cascaparomarket.dtos.RegisterRequestDTO;
import com.episodios.cascaparomarket.models.Role;
import com.episodios.cascaparomarket.models.User;
import com.episodios.cascaparomarket.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public TokenResponseDTO register(RegisterRequestDTO registerRequestDTO) {
        User user = User.builder()
                .name(registerRequestDTO.getUserName())
                .email(registerRequestDTO.getUserEmail())
                .password(passwordEncoder.encode(registerRequestDTO.getUserPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(user);

        return TokenResponseDTO.builder()
                .token(jwtService.getToken(user))
                .build();
    }

}
