package br.com.pooj.cotavia.core.interfaces.customer;

import java.util.Optional;

import br.com.pooj.cotavia.api.dtos.response.CustomerResponseDto;

public interface FindCustomerByEmailCase {
    Optional<CustomerResponseDto> execute(String email);
}
