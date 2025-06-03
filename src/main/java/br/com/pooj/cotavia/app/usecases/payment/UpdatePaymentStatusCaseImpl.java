package br.com.pooj.cotavia.app.usecases.payment;

import org.springframework.stereotype.Service;

import br.com.pooj.cotavia.core.enums.PaymentStatus;
import br.com.pooj.cotavia.core.interfaces.payment.UpdatePaymentStatusCase;
import br.com.pooj.cotavia.core.models.Payment;
import br.com.pooj.cotavia.core.repositories.PaymentRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UpdatePaymentStatusCaseImpl implements UpdatePaymentStatusCase {
    private final PaymentRepository paymentRepository;

    @Override
    public void execute(Long paymentId, PaymentStatus newStatus) {
        Payment payment = paymentRepository.findById(paymentId)
            .orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));

        payment.setStatus(newStatus);
        paymentRepository.save(payment);
    }
}
