package br.com.pooj.cotavia.application.usecases.pagamento;

import br.com.pooj.cotavia.domain.model.Pagamento;
import br.com.pooj.cotavia.infrastructure.persistence.entity.PagamentoEntity;
import br.com.pooj.cotavia.infrastructure.persistence.mapper.PagamentoEntityMapper;
import br.com.pooj.cotavia.infrastructure.persistence.repository.PagamentoJpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AtualizarPagamentoService {
    private final PagamentoJpaRepository pagamentoRepository;

    public AtualizarPagamentoService(PagamentoJpaRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    public Optional<Pagamento> atualizar(Long id, Pagamento novosDados) {
        Optional<PagamentoEntity> pagamentoExistente = pagamentoRepository.findById(id);

        if (pagamentoExistente.isEmpty()) return Optional.empty();

        PagamentoEntity pagamento = pagamentoExistente.get();
        pagamento.setValor(novosDados.getValor());
        pagamento.setData(novosDados.getData());
        pagamento.setFormaPagamento(novosDados.getFormaPagamento());

        PagamentoEntity pagamentoAtualizado = pagamentoRepository.save(pagamento);
        return Optional.of(PagamentoEntityMapper.toDomain(pagamentoAtualizado));
    }
}
