package com.episodios.cascaparomarket.services;

import com.episodios.cascaparomarket.dtos.AuthResponseDTO;
import com.episodios.cascaparomarket.dtos.LoginDTO;
import com.episodios.cascaparomarket.dtos.RegisterDTO;
import com.episodios.cascaparomarket.models.Role;
import com.episodios.cascaparomarket.models.User;
import com.episodios.cascaparomarket.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthResponseDTO login(LoginDTO loginDTO) {
        return null;
    }

    public AuthResponseDTO register(RegisterDTO registerDTO) {
        User user = User.builder()
                .userName(registerDTO.getUsername())
                .password(registerDTO.getPassword())
                .firstName(registerDTO.getFistName())
                .lastName(registerDTO.getLastName())
                .role(Role.USER)
                .build();

        userRepository.save(user);

        return AuthResponseDTO.builder()
                .token(jwtService.getToken(user))
                .build();
    }

}
