package br.com.pooj.cotavia.app.usecases.payment;

import org.springframework.stereotype.Service;

import br.com.pooj.cotavia.core.interfaces.payment.RemovePaymentCase;
import br.com.pooj.cotavia.core.repositories.PaymentRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RemovePaymentCaseImpl implements RemovePaymentCase {
    private final PaymentRepository paymentRepository;

    @Override
    public void execute(Long id) {
        if (!paymentRepository.existsById(id)){
            throw new RuntimeException("Pagamento não encontrado");
        }

        paymentRepository.deleteById(id);
    }
}
