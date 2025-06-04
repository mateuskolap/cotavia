package br.com.pooj.cotavia.app.usecases.customer;

import org.springframework.stereotype.Service;

import br.com.pooj.cotavia.api.dtos.request.CreateCustomerRequestDto;
import br.com.pooj.cotavia.api.dtos.response.CustomerResponseDto;
import br.com.pooj.cotavia.api.mappers.CustomerDtoMapper;
import br.com.pooj.cotavia.core.interfaces.customer.CreateCustomerCase;
import br.com.pooj.cotavia.core.models.Customer;
import br.com.pooj.cotavia.core.repositories.CustomerRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CreateCustomerCaseImpl implements CreateCustomerCase {
    private final CustomerRepository customerRepository;
    
    private final CustomerDtoMapper customerDtoMapper;

    @Override
    public CustomerResponseDto execute(CreateCustomerRequestDto request) {
        Customer customer = customerDtoMapper.toDomain(request);
        Customer saved = customerRepository.save(customer);

        return customerDtoMapper.toResponse(saved);
    }
}
