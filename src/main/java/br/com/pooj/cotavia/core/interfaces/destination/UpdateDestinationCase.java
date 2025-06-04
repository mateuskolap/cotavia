package br.com.pooj.cotavia.core.interfaces.destination;

import br.com.pooj.cotavia.api.dtos.request.CreateDestinationRequestDto;
import br.com.pooj.cotavia.api.dtos.response.DestinationResponseDto;

public interface UpdateDestinationCase {
    DestinationResponseDto execute(Long id, CreateDestinationRequestDto updatedDestination);
}
