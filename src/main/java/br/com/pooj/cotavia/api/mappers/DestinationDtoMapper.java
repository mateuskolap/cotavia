package br.com.pooj.cotavia.api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.pooj.cotavia.api.dtos.request.CreateDestinationRequest;
import br.com.pooj.cotavia.api.dtos.response.DestinationResponse;
import br.com.pooj.cotavia.core.models.Destination;

@Mapper(componentModel = "spring")
public interface DestinationDtoMapper {
    @Mapping(target = "id", ignore = true)
    Destination toDomain(CreateDestinationRequest request);

    DestinationResponse toResponse(Destination destination);
}
