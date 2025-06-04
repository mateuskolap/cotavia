package br.com.pooj.cotavia.api.mappers;

import org.springframework.stereotype.Component;

import br.com.pooj.cotavia.api.dtos.request.CreateDestinationRequestDto;
import br.com.pooj.cotavia.api.dtos.response.DestinationResponseDTO;
import br.com.pooj.cotavia.core.models.Destination;

@Component
public class DestinationDtoMapper {
    public Destination toDomain(CreateDestinationRequestDto request) {
        if (request == null) {
            return null;
        }
        Destination destination = new Destination();

        destination.setName(request.getName());
        destination.setDescription(request.getDescription());
        destination.setAddress(request.getAddress());
        destination.setPricePerPerson(request.getPricePerPerson());
        return destination;
    }

    public DestinationResponseDTO toResponse(Destination domain) {
        if (domain == null) {
            return null;
        }
        DestinationResponseDTO destination = new DestinationResponseDTO();

        destination.setId(domain.getId());
        destination.setName(domain.getName());
        destination.setDescription(domain.getDescription());
        destination.setAddress(domain.getAddress());
        destination.setPricePerPerson(domain.getPricePerPerson());

        return destination;
    }
}
