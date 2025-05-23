package br.com.pooj.cotavia.application.usecases.desconto;

import br.com.pooj.cotavia.domain.model.Desconto;
import br.com.pooj.cotavia.infrastructure.persistence.entity.DescontoEntity;
import br.com.pooj.cotavia.infrastructure.persistence.mapper.DescontoEntityMapper;
import br.com.pooj.cotavia.infrastructure.persistence.repository.DescontoJpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrarDescontoService {
    private final DescontoJpaRepository descontoRepository;

    public RegistrarDescontoService(DescontoJpaRepository descontoRepository) {
        this.descontoRepository = descontoRepository;
    }

    public Desconto registrar(Desconto desconto) {
        DescontoEntity cadastrado = descontoRepository.save(DescontoEntityMapper.toEntity(desconto));
        return DescontoEntityMapper.toDomain(cadastrado);
    }
}
