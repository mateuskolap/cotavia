package br.com.pooj.cotavia.application.usecases.cotacao;

import br.com.pooj.cotavia.infrastructure.persistence.repository.CotacaoJpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DeletarCotacaoService {
    private final CotacaoJpaRepository cotacaoRepository;

    public DeletarCotacaoService(CotacaoJpaRepository cotacaoRepository) {
        this.cotacaoRepository = cotacaoRepository;
    }

    public boolean deletar(Long id) {
        if (!cotacaoRepository.existsById(id)) {
            return false;
        }

        cotacaoRepository.deleteById(id);
        return true;
    }
}
