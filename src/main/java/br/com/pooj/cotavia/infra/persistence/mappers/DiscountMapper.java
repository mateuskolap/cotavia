package br.com.pooj.cotavia.infra.persistence.mappers;

import org.mapstruct.Mapper;

import br.com.pooj.cotavia.core.models.Discount;
import br.com.pooj.cotavia.infra.persistence.entities.DiscountEntity;

@Mapper(componentModel = "spring")
public interface DiscountMapper {
    DiscountEntity toEntity(Discount d);
    Discount toModel(DiscountEntity e);
}