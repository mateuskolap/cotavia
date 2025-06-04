package br.com.pooj.cotavia.app.usecases.destination;

import org.springframework.stereotype.Service;

import br.com.pooj.cotavia.api.dtos.request.CreateDestinationRequestDto;
import br.com.pooj.cotavia.api.dtos.response.DestinationResponseDto;
import br.com.pooj.cotavia.api.mappers.DestinationDtoMapper;
import br.com.pooj.cotavia.core.interfaces.destination.RegisterDestinationCase;
import br.com.pooj.cotavia.core.models.Destination;
import br.com.pooj.cotavia.core.repositories.DestinationRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegisterDestinationCaseImpl implements RegisterDestinationCase {
    private final DestinationRepository destinationRepository;
    
    private final DestinationDtoMapper destinationDtoMapper;

    @Override
    public DestinationResponseDto execute(CreateDestinationRequestDto request) {
        Destination destination = destinationDtoMapper.toDomain(request);
        Destination saved = destinationRepository.save(destination);

        return destinationDtoMapper.toResponse(saved);
    }
}
