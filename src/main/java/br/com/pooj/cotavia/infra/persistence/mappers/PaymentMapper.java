package br.com.pooj.cotavia.infra.persistence.mappers;

import org.mapstruct.Mapper;

import br.com.pooj.cotavia.core.models.Payment;
import br.com.pooj.cotavia.infra.persistence.entities.PaymentEntity;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    PaymentEntity toEntity(Payment d);
    Payment toModel(PaymentEntity e);
}
