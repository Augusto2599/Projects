package com.augusto.payment_API.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String senha;
}