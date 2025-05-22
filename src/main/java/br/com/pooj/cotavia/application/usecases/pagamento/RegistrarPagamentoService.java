package br.com.pooj.cotavia.application.usecases.pagamento;

import br.com.pooj.cotavia.domain.model.Pagamento;
import br.com.pooj.cotavia.infrastructure.persistence.entity.PagamentoEntity;
import br.com.pooj.cotavia.infrastructure.persistence.mapper.PagamentoEntityMapper;
import br.com.pooj.cotavia.infrastructure.persistence.repository.PagamentoJpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrarPagamentoService {
    private final PagamentoJpaRepository pagamentoRepository;

    public RegistrarPagamentoService(PagamentoJpaRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    public Pagamento registrar(Pagamento pagamento) {
        PagamentoEntity cadastrado = pagamentoRepository.save(PagamentoEntityMapper.toEntity(pagamento));
        return PagamentoEntityMapper.toDomain(cadastrado);
    }
}
