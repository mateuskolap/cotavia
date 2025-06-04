package br.com.pooj.cotavia.app.usecases.destination;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.pooj.cotavia.api.dtos.response.DestinationResponseDto;
import br.com.pooj.cotavia.api.mappers.DestinationDtoMapper;
import br.com.pooj.cotavia.core.interfaces.destination.ListDestinationCase;
import br.com.pooj.cotavia.core.repositories.DestinationRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ListDestinationCaseImpl implements ListDestinationCase {
    private final DestinationRepository destinationRepository;

    private final DestinationDtoMapper destinationDtoMapper;

    @Override
    public List<DestinationResponseDto> execute() {
        return destinationRepository.findAll()
            .stream()
            .map(destinationDtoMapper::toResponse)
            .collect(Collectors.toList());
    }
}
