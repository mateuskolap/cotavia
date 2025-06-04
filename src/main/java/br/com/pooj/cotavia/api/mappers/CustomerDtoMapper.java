package br.com.pooj.cotavia.api.mappers;

import org.springframework.stereotype.Component;

import br.com.pooj.cotavia.api.dtos.request.CreateCustomerRequestDto;
import br.com.pooj.cotavia.api.dtos.response.CustomerResponseDto;
import br.com.pooj.cotavia.core.models.Customer;

@Component
public class CustomerDtoMapper {
    public Customer toDomain(CreateCustomerRequestDto request) {
        if (request == null) {
            return null;
        }
        Customer customer = new Customer();

        customer.setName(request.getName());
        customer.setEmail(request.getEmail());
        customer.setPhoneNumber(request.getPhoneNumber());
        customer.setDocument(request.getDocument());
        return customer;
    }

    public CustomerResponseDto toResponse(Customer domain) {
        if (domain == null) {
            return null;
        }
        CustomerResponseDto dto = new CustomerResponseDto();

        dto.setId(domain.getId());
        dto.setName(domain.getName());
        dto.setEmail(domain.getEmail());
        dto.setPhoneNumber(domain.getPhoneNumber());
        dto.setDocument(domain.getDocument());

        return dto;
    }
}
