package com.augusto.login_signin.controller;

import com.augusto.login_signin.dto.ForgotPasswordRequest;
import com.augusto.login_signin.service.ForgotPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class ForgotPasswordController {

    @Autowired
    private ForgotPasswordService forgotPasswordService;

    @PostMapping("/forgot-password")
    public String resetPassword(@RequestBody ForgotPasswordRequest request) {
        boolean success = forgotPasswordService.resetPassword(request);
        return success ? "Senha redefinida com sucesso!" : "Usuário não encontrado.";
    }
}