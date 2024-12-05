package com.episodios.cascaparomarket.controllers;


import com.episodios.cascaparomarket.dtos.TokenResponseDTO;
import com.episodios.cascaparomarket.dtos.LoginRequestDTO;
import com.episodios.cascaparomarket.dtos.RegisterRequestDTO;
import com.episodios.cascaparomarket.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")

public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    @CrossOrigin
    public ResponseEntity<TokenResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        return ResponseEntity.ok(authService.login(loginRequestDTO));
    }

    @PostMapping("/register")
    @CrossOrigin
    public ResponseEntity<TokenResponseDTO> register(@RequestBody RegisterRequestDTO registerRequestDTO) {
        return ResponseEntity.ok(authService.register(registerRequestDTO));
    }
}