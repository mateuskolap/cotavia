package br.com.pooj.cotavia.app.usecases.customer;

import org.springframework.stereotype.Service;

import br.com.pooj.cotavia.core.interfaces.customer.CreateCustomerCase;
import br.com.pooj.cotavia.core.models.Customer;
import br.com.pooj.cotavia.core.repositories.CustomerRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CreateCustomerCaseImpl implements CreateCustomerCase {
    private final CustomerRepository customerRepository;

    @Override
    public Customer execute(Customer customer) {
        return customerRepository.save(customer);
    }
}
