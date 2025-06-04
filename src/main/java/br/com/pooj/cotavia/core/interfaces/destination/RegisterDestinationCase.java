package br.com.pooj.cotavia.core.interfaces.destination;

import br.com.pooj.cotavia.api.dtos.request.CreateDestinationRequestDto;
import br.com.pooj.cotavia.api.dtos.response.DestinationResponseDto;

public interface RegisterDestinationCase {
    DestinationResponseDto execute(CreateDestinationRequestDto destination);
}
