package br.com.pooj.cotavia.core.interfaces.destination;

import br.com.pooj.cotavia.core.models.Destination;

public interface UpdateDestinationCase {
    Destination execute(Long id, Destination updatedDestination);
}
