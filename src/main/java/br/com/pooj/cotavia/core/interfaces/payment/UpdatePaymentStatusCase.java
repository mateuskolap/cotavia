package br.com.pooj.cotavia.core.interfaces.payment;

import br.com.pooj.cotavia.core.enums.PaymentStatus;

public interface UpdatePaymentStatusCase {
    void execute(Long paymentId, PaymentStatus newStatus);
}
