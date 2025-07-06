package com.augusto.payment_API.exception;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponse {

    private String mensagem;
    private int status;
    private Object detalhes;
    private LocalDateTime timestamp;
}