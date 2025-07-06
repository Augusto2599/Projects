package com.augusto.payment_API.dto;

import com.augusto.payment_API.model.StatusPagamento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PagamentoResponse {

    private Long id;
    private BigDecimal valor;
    private LocalDateTime data;
    private StatusPagamento status;
    private String metodoPagamento;
    private String descricao;
}
