package br.com.pooj.cotavia.core.interfaces.payment;

import java.util.Optional;

import br.com.pooj.cotavia.core.models.Payment;

public interface FindPaymentByIdCase {
    Optional<Payment> execute(Long id);
}
