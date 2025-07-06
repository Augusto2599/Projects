package com.augusto.payment_API.controller;

import com.augusto.payment_API.dto.PagamentoRequest;
import com.augusto.payment_API.dto.PagamentoResponse;
import com.augusto.payment_API.service.interfaces.PagamentoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {

    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @PostMapping
    public ResponseEntity<PagamentoResponse> realizarPagamento(@RequestBody @Valid PagamentoRequest request) {
        PagamentoResponse response = pagamentoService.processarPagamento(request);
        return ResponseEntity.ok(response);
    }
}
