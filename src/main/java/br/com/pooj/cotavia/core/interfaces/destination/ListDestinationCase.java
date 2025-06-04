package br.com.pooj.cotavia.core.interfaces.destination;

import java.util.List;

import br.com.pooj.cotavia.api.dtos.response.DestinationResponseDto;

public interface ListDestinationCase {
    List<DestinationResponseDto> execute();
}
