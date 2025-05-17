package br.com.pooj.cotavia.application.usecases.cotacao;

import br.com.pooj.cotavia.domain.enums.StatusCotacao;
import br.com.pooj.cotavia.domain.model.Cotacao;
import br.com.pooj.cotavia.infrastructure.persistence.entity.CotacaoEntity;
import br.com.pooj.cotavia.infrastructure.persistence.mapper.CotacaoEntityMapper;
import br.com.pooj.cotavia.infrastructure.persistence.repository.CotacaoJpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AtualizarStatusCotacaoService {
    private final CotacaoJpaRepository cotacaoRepository;

    public AtualizarStatusCotacaoService(CotacaoJpaRepository cotacaoRepository) {
        this.cotacaoRepository = cotacaoRepository;
    }

    public Optional<Cotacao> atualizarStatus(Long id, StatusCotacao novoStatus) {
        return cotacaoRepository.findById(id)
                .map(cotacaoEntity -> {
                    cotacaoEntity.setStatus(novoStatus);
                    CotacaoEntity atualizada = cotacaoRepository.save(cotacaoEntity);
                    return CotacaoEntityMapper.toDomain(atualizada);
                });
    }
}
