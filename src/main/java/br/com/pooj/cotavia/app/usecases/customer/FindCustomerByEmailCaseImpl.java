package br.com.pooj.cotavia.app.usecases.customer;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.pooj.cotavia.api.dtos.response.CustomerResponseDto;
import br.com.pooj.cotavia.api.mappers.CustomerDtoMapper;
import br.com.pooj.cotavia.core.interfaces.customer.FindCustomerByEmailCase;
import br.com.pooj.cotavia.core.repositories.CustomerRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FindCustomerByEmailCaseImpl implements FindCustomerByEmailCase {
    private final CustomerRepository customerRepository;

    private final CustomerDtoMapper customerDtoMapper;

    @Override
    public Optional<CustomerResponseDto> execute(String email) {
        return customerRepository.findByEmail(email)
                                 .map(customerDtoMapper::toResponse);
    }
}
