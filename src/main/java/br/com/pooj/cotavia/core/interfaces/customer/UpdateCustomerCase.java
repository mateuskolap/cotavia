package br.com.pooj.cotavia.core.interfaces.customer;

import br.com.pooj.cotavia.api.dtos.request.CreateCustomerRequestDto;
import br.com.pooj.cotavia.api.dtos.response.CustomerResponseDto;

public interface UpdateCustomerCase {
    CustomerResponseDto execute(Long id, CreateCustomerRequestDto updatedCustomer);
}
