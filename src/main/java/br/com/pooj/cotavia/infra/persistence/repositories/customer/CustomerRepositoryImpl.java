package br.com.pooj.cotavia.infra.persistence.repositories.customer;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.pooj.cotavia.core.models.Customer;
import br.com.pooj.cotavia.core.repositories.CustomerRepository;
import br.com.pooj.cotavia.infra.persistence.entities.CustomerEntity;
import br.com.pooj.cotavia.infra.persistence.mappers.CustomerMapper;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {
    private final SpringCustomerJpaRepository jpaRepository;
    private final CustomerMapper customerMapper;

    @Override
    public Customer save(Customer customer) {
        CustomerEntity entity = customerMapper.toEntity(customer);
        CustomerEntity saved = jpaRepository.save(entity);

        return customerMapper.toModel(saved);
    }

    @Override
    public List<Customer> findAll() {
        return jpaRepository.findAll()
                            .stream()
                            .map(customerMapper::toModel)
                            .collect(Collectors.toList());
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        return jpaRepository.findByEmail(email)
                            .map(customerMapper::toModel);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return jpaRepository.findById(id)
                            .map(customerMapper::toModel);
    }
}
