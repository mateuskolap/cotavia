package br.com.pooj.cotavia.api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.pooj.cotavia.api.dtos.request.CreateCustomerRequest;
import br.com.pooj.cotavia.api.dtos.response.CustomerResponse;
import br.com.pooj.cotavia.core.models.Customer;

@Mapper(componentModel = "spring")
public interface CustomerDtoMapper {
    @Mapping(target = "id", ignore = true)
    Customer toDomain(CreateCustomerRequest request);
    CustomerResponse toResponse(Customer customer);
}
