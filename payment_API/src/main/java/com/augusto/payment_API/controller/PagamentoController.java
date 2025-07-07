package com.augusto.payment_API.controller;

import com.augusto.payment_API.dto.PagamentoRequest;
import com.augusto.payment_API.dto.PagamentoResponse;
import com.augusto.payment_API.service.interfaces.PagamentoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoResponse> buscarPorId(@PathVariable Long id) {
        PagamentoResponse pagamento = pagamentoService.buscarPorId(id);
        return ResponseEntity.ok(pagamento);
    }

    @GetMapping
    public ResponseEntity<List<PagamentoResponse>> listarTodos() {
        List<PagamentoResponse> pagamentos = pagamentoService.listarTodos();
        return ResponseEntity.ok(pagamentos);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        pagamentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
