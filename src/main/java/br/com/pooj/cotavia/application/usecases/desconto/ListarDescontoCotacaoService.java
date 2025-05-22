package br.com.pooj.cotavia.application.usecases.desconto;

import br.com.pooj.cotavia.application.dtos.DescontoDTO;
import br.com.pooj.cotavia.domain.repositories.DescontoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarDescontoCotacaoService {
    private final DescontoRepository descontoRepository;

    public ListarDescontoCotacaoService(DescontoRepository descontoRepository) {
        this.descontoRepository = descontoRepository;
    }

    public List<DescontoDTO> listarDescontos() {
        return descontoRepository.findAll()
                .stream()
                .map(DescontoDTO::new)
                .collect(Collectors.toList());
    }
}
