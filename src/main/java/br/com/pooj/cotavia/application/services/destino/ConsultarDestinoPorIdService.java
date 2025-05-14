package br.com.pooj.cotavia.application.services.destino;

import br.com.pooj.cotavia.domain.model.Destino;
import br.com.pooj.cotavia.infrastructure.persistence.mapper.DestinoMapper;
import br.com.pooj.cotavia.infrastructure.persistence.repository.DestinoJpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConsultarDestinoPorIdService {
    private final DestinoJpaRepository destinoRepository;

    public ConsultarDestinoPorIdService(DestinoJpaRepository destinoRepository) { this.destinoRepository = destinoRepository; }

    public Optional<Destino> consultarPorId(Long id) {
        return destinoRepository.findById(id)
                .map(DestinoMapper::toDomain);
    }
}
