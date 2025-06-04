package br.com.pooj.cotavia.core.interfaces.customer;

import java.util.List;

import br.com.pooj.cotavia.api.dtos.response.CustomerResponseDto;

public interface ListCustomerCase {
    List<CustomerResponseDto> execute();
}
