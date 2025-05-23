package br.com.pooj.cotavia.application.usecases.desconto;

import br.com.pooj.cotavia.domain.model.Desconto;
import br.com.pooj.cotavia.infrastructure.persistence.mapper.DescontoEntityMapper;
import br.com.pooj.cotavia.infrastructure.persistence.repository.DescontoJpaRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarDescontoCotacaoService {
    private final DescontoJpaRepository descontoRepository;

    public ListarDescontoCotacaoService(DescontoJpaRepository descontoRepository) {
        this.descontoRepository = descontoRepository;
    }

    public List<Desconto> listarTodos() {
        return descontoRepository.findAll()
                .stream()
                .map(DescontoEntityMapper::toDomain)
                .collect(Collectors.toList());
    }
}
