package com.augusto.login_signin.controller;

import com.augusto.login_signin.dto.ApiResponse;
import com.augusto.login_signin.dto.LoginRequest;
import com.augusto.login_signin.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ApiResponse> login(@RequestBody LoginRequest request) {
        boolean isAuthenticated = authService.login(request);
        if (isAuthenticated) {
            return ResponseEntity.ok(new ApiResponse(true, "Login realizado com sucesso!"));
        } else {
            return ResponseEntity.status(401).body(new ApiResponse(false, "Credenciais inválidas."));
        }
    }
}