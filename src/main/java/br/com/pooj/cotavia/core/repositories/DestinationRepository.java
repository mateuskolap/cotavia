package br.com.pooj.cotavia.core.repositories;

import java.util.List;
import java.util.Optional;

import br.com.pooj.cotavia.core.models.Destination;

public interface DestinationRepository {
    Destination save(Destination destination);
    List<Destination> findAll();
    Optional<Destination> findById(Long id);
    void deleteById(Long id);
    boolean existsById(Long id);
}
