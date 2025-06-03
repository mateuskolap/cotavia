package br.com.pooj.cotavia.infra.persistence.mappers;

import org.mapstruct.Mapper;

import br.com.pooj.cotavia.core.models.Destination;
import br.com.pooj.cotavia.infra.persistence.entities.DestinationEntity;

@Mapper(componentModel = "spring")
public interface DestinationMapper {
    DestinationEntity toEntity(Destination d);
    Destination toModel(DestinationEntity e);
}
