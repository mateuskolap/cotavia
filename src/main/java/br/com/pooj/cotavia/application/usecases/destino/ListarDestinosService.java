package br.com.pooj.cotavia.application.usecases.destino;

import br.com.pooj.cotavia.domain.model.Destino;
import br.com.pooj.cotavia.infrastructure.persistence.mapper.DestinoEntityMapper;
import br.com.pooj.cotavia.infrastructure.persistence.repository.DestinoJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarDestinosService {
    private final DestinoJpaRepository destinoRepository;

    public ListarDestinosService(DestinoJpaRepository destinoRepository) {this.destinoRepository = destinoRepository; }

    public List<Destino> listarTodos() {
        return destinoRepository.findAll()
                .stream()
                .map(DestinoEntityMapper::toDomain)
                .collect(Collectors.toList());
    }
}
