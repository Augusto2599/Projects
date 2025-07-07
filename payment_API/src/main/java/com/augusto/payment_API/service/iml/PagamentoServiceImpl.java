package com.augusto.payment_API.service.iml;

import com.augusto.payment_API.dto.PagamentoRequest;
import com.augusto.payment_API.dto.PagamentoResponse;
import com.augusto.payment_API.exception.RecursoNaoEncontradoException;
import com.augusto.payment_API.model.Pagamento;
import com.augusto.payment_API.model.StatusPagamento;
import com.augusto.payment_API.repository.PagamentoRepository;
import com.augusto.payment_API.service.interfaces.PagamentoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PagamentoServiceImpl implements PagamentoService {

    private final PagamentoRepository pagamentoRepository;
    private final ModelMapper modelMapper;

    public PagamentoServiceImpl(PagamentoRepository pagamentoRepository, ModelMapper modelMapper) {
        this.pagamentoRepository = pagamentoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PagamentoResponse processarPagamento(PagamentoRequest request) {
        Pagamento pagamento = modelMapper.map(request, Pagamento.class);

        pagamento.setData(LocalDateTime.now());
        pagamento.setStatus(StatusPagamento.PROCESSANDO);

        pagamento = pagamentoRepository.save(pagamento);

        pagamento.setStatus(StatusPagamento.APROVADO);
        pagamento = pagamentoRepository.save(pagamento);

        return modelMapper.map(pagamento, PagamentoResponse.class);
    }

    @Override
    public PagamentoResponse buscarPorId(Long id) {
        Pagamento pagamento = pagamentoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Pagamento com ID " + id + " não encontrado."));
        return modelMapper.map(pagamento, PagamentoResponse.class);
    }

    @Override
    public List<PagamentoResponse> listarTodos() {
        return pagamentoRepository.findAll()
                .stream()
                .map(p -> modelMapper.map(p, PagamentoResponse.class))
                .toList();
    }

    @Override
    public void deletar(Long id) {
        Pagamento pagamento = pagamentoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Pagamento com ID " + id + " não encontrado."));
        pagamentoRepository.delete(pagamento);
    }
}
