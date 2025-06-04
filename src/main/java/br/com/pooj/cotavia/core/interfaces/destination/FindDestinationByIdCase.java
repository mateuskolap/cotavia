package br.com.pooj.cotavia.core.interfaces.destination;

import java.util.Optional;

import br.com.pooj.cotavia.api.dtos.response.DestinationResponseDto;

public interface FindDestinationByIdCase {
    Optional<DestinationResponseDto> execute(Long id);
}
