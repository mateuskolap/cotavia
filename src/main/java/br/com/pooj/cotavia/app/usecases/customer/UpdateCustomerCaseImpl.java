package br.com.pooj.cotavia.app.usecases.customer;

import org.springframework.stereotype.Service;

import br.com.pooj.cotavia.api.dtos.request.CreateCustomerRequestDto;
import br.com.pooj.cotavia.api.dtos.response.CustomerResponseDto;
import br.com.pooj.cotavia.api.mappers.CustomerDtoMapper;
import br.com.pooj.cotavia.core.interfaces.customer.UpdateCustomerCase;
import br.com.pooj.cotavia.core.models.Customer;
import br.com.pooj.cotavia.core.repositories.CustomerRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UpdateCustomerCaseImpl implements UpdateCustomerCase {
    private final CustomerRepository customerRepository;

    private final CustomerDtoMapper customerDtoMapper;

    @Override
    public CustomerResponseDto execute(Long id, CreateCustomerRequestDto request) {
        Customer existing = customerRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        
        existing.setName(request.getName());
        existing.setEmail(request.getEmail());
        existing.setPhoneNumber(request.getPhoneNumber());
        existing.setDocument(request.getDocument());

        Customer updated = customerRepository.save(existing);
        return customerDtoMapper.toResponse(updated);
    }
}
