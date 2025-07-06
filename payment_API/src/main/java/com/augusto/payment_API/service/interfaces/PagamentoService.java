package com.augusto.payment_API.service.interfaces;

import com.augusto.payment_API.dto.PagamentoRequest;
import com.augusto.payment_API.dto.PagamentoResponse;

public interface PagamentoService {
    PagamentoResponse processarPagamento(PagamentoRequest request);
}
