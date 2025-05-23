package br.com.pooj.cotavia.application.usecases.pagamento;

import br.com.pooj.cotavia.domain.enums.StatusPagamentoEnum;
import br.com.pooj.cotavia.domain.model.Pagamento;
import br.com.pooj.cotavia.infrastructure.persistence.entity.PagamentoEntity;
import br.com.pooj.cotavia.infrastructure.persistence.mapper.PagamentoEntityMapper;
import br.com.pooj.cotavia.infrastructure.persistence.repository.PagamentoJpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AtualizarStatusPagamentoService {
    private final PagamentoJpaRepository pagamentoRepository;

    public AtualizarStatusPagamentoService(PagamentoJpaRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    public Optional<Pagamento> atualizarStatus(Long id, StatusPagamentoEnum novoStatus) {
        return pagamentoRepository.findById(id)
                .map(pagamentoEntity -> {
                    pagamentoEntity.setStatus(novoStatus);
                    PagamentoEntity atualizada = pagamentoRepository.save(pagamentoEntity);
                    return PagamentoEntityMapper.toDomain(atualizada);
                });
    }
}
