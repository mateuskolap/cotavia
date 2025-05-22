package br.com.pooj.cotavia.application.usecases.pagamento;

import br.com.pooj.cotavia.domain.model.Pagamento;
import br.com.pooj.cotavia.infrastructure.persistence.mapper.PagamentoEntityMapper;
import br.com.pooj.cotavia.infrastructure.persistence.repository.PagamentoJpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ObterPagamentoService {
    private final PagamentoJpaRepository pagamentoRepository;

    public ObterPagamentoService(PagamentoJpaRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    public Pagamento obter(Long id) {
        return PagamentoEntityMapper.toDomain(pagamentoRepository.findById(id).orElseThrow());
    }
}
