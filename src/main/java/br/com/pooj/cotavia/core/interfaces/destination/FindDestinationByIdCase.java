package br.com.pooj.cotavia.core.interfaces.destination;

import java.util.Optional;

import br.com.pooj.cotavia.core.models.Destination;

public interface FindDestinationByIdCase {
    Optional<Destination> execute(Long id);
}
