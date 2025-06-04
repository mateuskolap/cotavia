package br.com.pooj.cotavia.app.usecases.customer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.pooj.cotavia.api.dtos.response.CustomerResponseDto;
import br.com.pooj.cotavia.api.mappers.CustomerDtoMapper;
import br.com.pooj.cotavia.core.interfaces.customer.ListCustomerCase;
import br.com.pooj.cotavia.core.repositories.CustomerRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ListCustomerCaseImpl implements ListCustomerCase {
    private final CustomerRepository customerRepository;

    private final CustomerDtoMapper customerDtoMapper;

    @Override
    public List<CustomerResponseDto> execute() {
        return customerRepository.findAll()
                                 .stream()
                                 .map(customerDtoMapper::toResponse)
                                 .collect(Collectors.toList());
    }
}
