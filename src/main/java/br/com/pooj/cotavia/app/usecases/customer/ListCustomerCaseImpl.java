package br.com.pooj.cotavia.app.usecases.customer;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.pooj.cotavia.core.interfaces.customer.ListCustomerCase;
import br.com.pooj.cotavia.core.models.Customer;
import br.com.pooj.cotavia.core.repositories.CustomerRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ListCustomerCaseImpl implements ListCustomerCase {
    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> execute() {
        return customerRepository.findAll();
    }
}
