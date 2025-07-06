package com.augusto.login_signin.controller;

import com.augusto.login_signin.dto.ApiResponse;
import com.augusto.login_signin.dto.RegisterRequest;
import com.augusto.login_signin.service.RegisterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody RegisterRequest request) {
        boolean success = registerService.register(request);
        if (success) {
            return ResponseEntity.ok(new ApiResponse(true, "Usuário cadastrado com sucesso!"));
        } else {
            return ResponseEntity.status(400).body(new ApiResponse(false, "E-mail já está em uso."));
        }
    }
}