package br.com.pooj.cotavia.app.usecases.payment;

import org.springframework.stereotype.Service;

import br.com.pooj.cotavia.core.interfaces.payment.RegisterPaymentCase;
import br.com.pooj.cotavia.core.models.Payment;
import br.com.pooj.cotavia.core.repositories.PaymentRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegisterPaymentCaseImpl implements RegisterPaymentCase {
    private final PaymentRepository paymentRepository;

    @Override
    public Payment execute(Payment payment) {
        return paymentRepository.save(payment);
    }
}
