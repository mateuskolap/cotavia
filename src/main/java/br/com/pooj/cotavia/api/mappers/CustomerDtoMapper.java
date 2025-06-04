package br.com.pooj.cotavia.api.mappers;

import org.springframework.stereotype.Component;

import br.com.pooj.cotavia.api.dtos.request.CreateCustomerRequestDto;
import br.com.pooj.cotavia.api.dtos.response.CustomerResponseDTO;
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

    public CustomerResponseDTO toResponse(Customer domain) {
        if (domain == null) {
            return null;
        }
        CustomerResponseDTO customer = new CustomerResponseDTO();

        customer.setId(domain.getId());
        customer.setName(domain.getName());
        customer.setEmail(domain.getEmail());
        customer.setPhoneNumber(domain.getPhoneNumber());
        customer.setDocument(domain.getDocument());

        return customer;
    }
}
