package br.com.pooj.cotavia.infra.persistence.repositories.destination;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.pooj.cotavia.core.models.Destination;
import br.com.pooj.cotavia.core.repositories.DestinationRepository;
import br.com.pooj.cotavia.infra.persistence.entities.DestinationEntity;
import br.com.pooj.cotavia.infra.persistence.mappers.DestinationMapper;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class DestinationRepositoryImpl implements DestinationRepository {
    private final SpringDestinationJpaRepository jpaRepository;
    private final DestinationMapper destinationMapper;

    @Override
    public Destination save(Destination destination) {
        DestinationEntity entity = destinationMapper.toEntity(destination);
        DestinationEntity saved = jpaRepository.save(entity);

        return destinationMapper.toModel(saved);
    }

    @Override
    public List<Destination> findAll() {
        return jpaRepository.findAll()
                            .stream()
                            .map(destinationMapper::toModel)
                            .collect(Collectors.toList());
    }

    @Override
    public Optional<Destination> findById(Long id) {
        return jpaRepository.findById(id)
                            .map(destinationMapper::toModel);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaRepository.existsById(id);
    }
}
