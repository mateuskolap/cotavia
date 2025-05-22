package br.com.pooj.cotavia.application.usecases.desconto;

import br.com.pooj.cotavia.application.dtos.DescontoDTO;
import br.com.pooj.cotavia.application.exceptions.DescontoNotFoundException;
import br.com.pooj.cotavia.infrastructure.persistence.repository.DescontoJpaRepository;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DetalharDescontoService {
    private final DescontoJpaRepository descontoRepository;

    public DetalharDescontoService(DescontoJpaRepository descontoRepository) {
        this.descontoRepository = descontoRepository;
    }

    public DescontoDTO detalharDesconto(Long id) {
        return descontoRepository.findById(id)
                .map(DescontoDTO::new)
                .orElseThrow(() -> new DescontoNotFoundException("Desconto não encontrado"));
    }
}
