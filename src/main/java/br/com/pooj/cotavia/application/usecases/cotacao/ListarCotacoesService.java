package br.com.pooj.cotavia.application.usecases.cotacao;

import br.com.pooj.cotavia.domain.model.Cotacao;
import br.com.pooj.cotavia.infrastructure.persistence.mapper.CotacaoEntityMapper;
import br.com.pooj.cotavia.infrastructure.persistence.repository.CotacaoJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarCotacoesService {
    private final CotacaoJpaRepository cotacaoRepository;

    public ListarCotacoesService(CotacaoJpaRepository cotacaoRepository) {
        this.cotacaoRepository = cotacaoRepository;
    }

    public List<Cotacao> listarTodas() {
        return cotacaoRepository.findAll()
                .stream()
                .map(CotacaoEntityMapper::toDomain)
                .collect(Collectors.toList());
    }
}
