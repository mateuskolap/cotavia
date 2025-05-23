package br.com.pooj.cotavia.application.usecases.destino;

import br.com.pooj.cotavia.domain.model.Destino;
import br.com.pooj.cotavia.infrastructure.persistence.entity.DestinoEntity;
import br.com.pooj.cotavia.infrastructure.persistence.mapper.DestinoEntityMapper;
import br.com.pooj.cotavia.infrastructure.persistence.repository.DestinoJpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CadastrarDestinoService {
    private final DestinoJpaRepository destinoRepository;

    public CadastrarDestinoService(DestinoJpaRepository destinoRepository) {
        this.destinoRepository = destinoRepository;
    }

    public Destino cadastrar(Destino destino) {
        DestinoEntity cadastrado = destinoRepository.save(DestinoEntityMapper.toEntity(destino));
        return DestinoEntityMapper.toDomain(cadastrado);
    }
}
