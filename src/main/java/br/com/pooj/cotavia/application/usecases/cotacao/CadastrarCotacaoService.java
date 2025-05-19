package br.com.pooj.cotavia.application.usecases.cotacao;

import br.com.pooj.cotavia.domain.model.Cotacao;
import br.com.pooj.cotavia.infrastructure.persistence.entity.CotacaoEntity;
import br.com.pooj.cotavia.infrastructure.persistence.mapper.CotacaoEntityMapper;
import br.com.pooj.cotavia.infrastructure.persistence.repository.CotacaoJpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CadastrarCotacaoService {
    private final CotacaoJpaRepository cotacaoRepository;

    public CadastrarCotacaoService(CotacaoJpaRepository cotacaoRepository) {
        this.cotacaoRepository = cotacaoRepository;
    }

    public Cotacao cadastrar(Cotacao cotacao) {
        CotacaoEntity salvo = cotacaoRepository.save(CotacaoEntityMapper.toEntity(cotacao));
        return CotacaoEntityMapper.toDomain(salvo);
    }
}
