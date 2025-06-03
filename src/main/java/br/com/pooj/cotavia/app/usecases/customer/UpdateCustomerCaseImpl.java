package br.com.pooj.cotavia.app.usecases.customer;

import org.springframework.stereotype.Service;

import br.com.pooj.cotavia.core.interfaces.customer.UpdateCustomerCase;
import br.com.pooj.cotavia.core.models.Customer;
import br.com.pooj.cotavia.core.repositories.CustomerRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UpdateCustomerCaseImpl implements UpdateCustomerCase {
    private final CustomerRepository customerRepository;

    @Override
    public Customer execute(Long id, Customer updatedCustomer) {
        Customer existing = customerRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
            
        existing.setName(updatedCustomer.getName());
        existing.setEmail(updatedCustomer.getEmail());
        existing.setPhoneNumber(updatedCustomer.getPhoneNumber());
        existing.setDocument(updatedCustomer.getDocument());

        return customerRepository.save(existing);
    }
}
