package br.com.pooj.cotavia.core.interfaces.customer;

import java.util.Optional;

import br.com.pooj.cotavia.core.models.Customer;

public interface FindCustomerByEmailCase {
    Optional<Customer> execute(String email);
}
