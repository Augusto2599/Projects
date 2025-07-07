package com.augusto.payment_API.service.interfaces;

import java.util.List;

import com.augusto.payment_API.dto.PagamentoRequest;
import com.augusto.payment_API.dto.PagamentoResponse;

public interface PagamentoService {
    PagamentoResponse processarPagamento(PagamentoRequest request);

    PagamentoResponse buscarPorId(Long id);

    List<PagamentoResponse> listarTodos();

    void deletar(Long id);
}
