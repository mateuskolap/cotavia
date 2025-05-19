package br.com.pooj.cotavia.application.usecases.cotacao;

import br.com.pooj.cotavia.domain.model.Cotacao;
import br.com.pooj.cotavia.infrastructure.persistence.mapper.CotacaoEntityMapper;
import br.com.pooj.cotavia.infrastructure.persistence.repository.CotacaoJpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConsultarCotacaoPorIdService {
    private final CotacaoJpaRepository cotacaoRepository;

    public ConsultarCotacaoPorIdService(CotacaoJpaRepository cotacaoRepository) {
        this.cotacaoRepository = cotacaoRepository;
    }

    public Optional<Cotacao> consultarPorId(Long id) {
        return cotacaoRepository.findById(id)
                .map(CotacaoEntityMapper::toDomain);
    }
}
