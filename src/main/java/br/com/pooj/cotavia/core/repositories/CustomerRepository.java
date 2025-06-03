package br.com.pooj.cotavia.core.repositories;

import java.util.List;
import java.util.Optional;

import br.com.pooj.cotavia.core.models.Customer;

public interface CustomerRepository {
    Customer save(Customer customer);
    List<Customer> findAll();
    Optional<Customer> findByEmail(String email);
    Optional<Customer> findById(Long id);
}
