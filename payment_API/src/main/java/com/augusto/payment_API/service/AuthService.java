package com.augusto.payment_API.service;

import com.augusto.payment_API.dto.AuthRequest;
import com.augusto.payment_API.dto.AuthResponse;
import com.augusto.payment_API.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;

    public AuthResponse login(AuthRequest request) {
        // Autenticar email/senha
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getSenha())
        );

        // Gerar token com email
        String token = jwtService.generateToken(request.getEmail());

        return new AuthResponse(token);
    }

}