package br.com.pooj.cotavia.core.repositories;

import java.util.Optional;

import br.com.pooj.cotavia.core.models.Payment;

public interface PaymentRepository {
    Payment save(Payment payment);
    Optional<Payment> findById(Long id);
    void deleteById(Long id);
    boolean existsById(Long id);
}
