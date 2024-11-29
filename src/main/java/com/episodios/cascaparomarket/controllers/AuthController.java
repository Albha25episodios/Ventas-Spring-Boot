package com.episodios.cascaparomarket.controllers;


import com.episodios.cascaparomarket.dtos.AuthResponseDTO;
import com.episodios.cascaparomarket.dtos.LoginDTO;
import com.episodios.cascaparomarket.dtos.RegisterDTO;
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
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDTO loginDTO) {
        return ResponseEntity.ok(authService.login(loginDTO));
    }

    @PostMapping("/register")
    @CrossOrigin
    public ResponseEntity<AuthResponseDTO> register(@RequestBody RegisterDTO registerDTO) {
        return ResponseEntity.ok(authService.register(registerDTO));
    }
}