package br.com.pooj.cotavia.core.interfaces.payment;

import br.com.pooj.cotavia.core.models.Payment;

public interface RegisterPaymentCase {
    Payment execute(Payment payment);
}
