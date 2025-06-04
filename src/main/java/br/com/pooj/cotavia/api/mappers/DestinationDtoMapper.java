package br.com.pooj.cotavia.api.mappers;

import org.springframework.stereotype.Component;

import br.com.pooj.cotavia.api.dtos.request.CreateDestinationRequestDto;
import br.com.pooj.cotavia.api.dtos.response.DestinationResponseDto;
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

    public DestinationResponseDto toResponse(Destination domain) {
        if (domain == null) {
            return null;
        }
        DestinationResponseDto dto = new DestinationResponseDto();

        dto.setId(domain.getId());
        dto.setName(domain.getName());
        dto.setDescription(domain.getDescription());
        dto.setAddress(domain.getAddress());
        dto.setPricePerPerson(domain.getPricePerPerson());

        return dto;
    }
}
