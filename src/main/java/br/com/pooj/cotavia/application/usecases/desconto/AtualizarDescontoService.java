package br.com.pooj.cotavia.application.usecases.desconto;

import br.com.pooj.cotavia.domain.model.Desconto;
import br.com.pooj.cotavia.infrastructure.persistence.entity.DescontoEntity;
import br.com.pooj.cotavia.infrastructure.persistence.mapper.DescontoEntityMapper;
import br.com.pooj.cotavia.infrastructure.persistence.repository.DescontoJpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AtualizarDescontoService {
    private final DescontoJpaRepository descontoRepository;

    public AtualizarDescontoService(DescontoJpaRepository descontoRepository) {
        this.descontoRepository = descontoRepository;
    }

    public Optional<Desconto> atualizar(Long id, br.com.pooj.cotavia.domain.model.Desconto novosDados) {
        Optional<DescontoEntity> descontoExistente = descontoRepository.findById(id);

        if (descontoExistente.isEmpty()) return Optional.empty();

        DescontoEntity desconto = descontoExistente.get();
        desconto.setValorDesconto(novosDados.getValorDesconto());
        desconto.setDescricao(novosDados.getDescricao());


        DescontoEntity descontoAtualizado = descontoRepository.save(desconto);
        return Optional.of(DescontoEntityMapper.toDomain(descontoAtualizado));
    }
}
