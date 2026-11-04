package com.biolab.ecommerce.controllers;

import com.biolab.ecommerce.DTOs.LoginDTO;
import com.biolab.ecommerce.service.CustomUserDetailsService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Login {

    private final CustomUserDetailsService customUserDetailsService;
    private final PasswordEncoder encoder;

    public Login(CustomUserDetailsService customUserDetailsService, PasswordEncoder encoder) {
        this.customUserDetailsService = customUserDetailsService;
        this.encoder = encoder;
    }


    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginDTO dto) {
        try {
            var u = customUserDetailsService.loadUserByUsername(dto.getEmail());
            if (!encoder.matches(dto.getSenha(),u.getPassword())) {
                return ResponseEntity.ok("Email ou Senha incorretos");
            }

            return ResponseEntity.ok("Logado com sucesso!! ");
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.ok("Usuario não encontrado. ");
        }
    }
}
