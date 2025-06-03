package br.com.pooj.cotavia.infra.persistence.repositories.customer;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pooj.cotavia.infra.persistence.entities.CustomerEntity;

public interface SpringCustomerJpaRepository extends JpaRepository<CustomerEntity, Long> {
    Optional<CustomerEntity> findByEmail(String email);
}
