package com.augusto.login_signin.controller;

import com.augusto.login_signin.dto.LoginRequest;
import com.augusto.login_signin.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        boolean isAuthenticated = authService.login(request);
        return isAuthenticated ? "Login realizado com sucesso!" : "Credenciais inválidas.";
    }
}