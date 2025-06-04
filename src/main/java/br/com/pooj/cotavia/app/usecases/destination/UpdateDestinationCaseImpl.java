package br.com.pooj.cotavia.app.usecases.destination;

import org.springframework.stereotype.Service;

import br.com.pooj.cotavia.api.dtos.request.CreateDestinationRequestDto;
import br.com.pooj.cotavia.api.dtos.response.DestinationResponseDto;
import br.com.pooj.cotavia.api.mappers.DestinationDtoMapper;
import br.com.pooj.cotavia.core.interfaces.destination.UpdateDestinationCase;
import br.com.pooj.cotavia.core.models.Destination;
import br.com.pooj.cotavia.core.repositories.DestinationRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UpdateDestinationCaseImpl implements UpdateDestinationCase {

    private final DestinationDtoMapper destinationDtoMapper;
    private final DestinationRepository destinationRepository;

    @Override
    public DestinationResponseDto execute(Long id, CreateDestinationRequestDto request) {
        Destination existing = destinationRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Destino não encontrado"));

        existing.setName(request.getName());
        existing.setDescription(request.getDescription());
        existing.setAddress(request.getAddress());
        existing.setPricePerPerson(request.getPricePerPerson());

        Destination updated = destinationRepository.save(existing);

        return destinationDtoMapper.toResponse(updated);
    }
}
