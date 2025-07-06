package com.augusto.login_signin.controller;

import com.augusto.login_signin.dto.RegisterRequest;
import com.augusto.login_signin.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String register(@RequestBody RegisterRequest request) {
        boolean success = registerService.register(request);
        return success ? "Usuário cadastrado com sucesso!" : "E-mail já está em uso.";
    }
}