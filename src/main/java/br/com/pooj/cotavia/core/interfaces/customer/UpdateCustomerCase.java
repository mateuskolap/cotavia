package br.com.pooj.cotavia.core.interfaces.customer;

import br.com.pooj.cotavia.core.models.Customer;

public interface UpdateCustomerCase {
    Customer execute(Long id, Customer updatedCustomer);
}
