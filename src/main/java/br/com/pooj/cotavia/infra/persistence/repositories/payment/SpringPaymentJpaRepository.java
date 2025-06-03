package br.com.pooj.cotavia.infra.persistence.repositories.payment;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pooj.cotavia.infra.persistence.entities.PaymentEntity;

public interface SpringPaymentJpaRepository extends JpaRepository<PaymentEntity, Long> {
    
}
