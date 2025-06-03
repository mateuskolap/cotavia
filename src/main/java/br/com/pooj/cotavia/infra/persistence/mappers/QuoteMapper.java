package br.com.pooj.cotavia.infra.persistence.mappers;

import org.mapstruct.Mapper;

import br.com.pooj.cotavia.core.models.Quote;
import br.com.pooj.cotavia.infra.persistence.entities.QuoteEntity;

@Mapper(componentModel = "spring")
public interface QuoteMapper {
    QuoteEntity toEntity(Quote d);
    Quote toModel(QuoteEntity e);
}
