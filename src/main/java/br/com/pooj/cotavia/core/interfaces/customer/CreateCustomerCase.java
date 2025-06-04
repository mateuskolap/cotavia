package br.com.pooj.cotavia.core.interfaces.customer;

import br.com.pooj.cotavia.api.dtos.request.CreateCustomerRequestDto;
import br.com.pooj.cotavia.api.dtos.response.CustomerResponseDto;

public interface CreateCustomerCase {
    CustomerResponseDto execute(CreateCustomerRequestDto customer);
}
