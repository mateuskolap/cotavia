package br.com.pooj.cotavia.app.usecases.payment;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.pooj.cotavia.core.interfaces.payment.FindPaymentByIdCase;
import br.com.pooj.cotavia.core.models.Payment;
import br.com.pooj.cotavia.core.repositories.PaymentRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FindPaymentByIdCaseImpl implements FindPaymentByIdCase {
    private final PaymentRepository paymentRepository;

    public Optional<Payment> execute(Long id) {
        return paymentRepository.findById(id);
    }
}
