package br.com.pooj.cotavia.infra.persistence.mappers;

import org.mapstruct.Mapper;

import br.com.pooj.cotavia.core.models.Customer;
import br.com.pooj.cotavia.infra.persistence.entities.CustomerEntity;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerEntity toEntity(Customer c);
    Customer toModel(CustomerEntity e);
}
