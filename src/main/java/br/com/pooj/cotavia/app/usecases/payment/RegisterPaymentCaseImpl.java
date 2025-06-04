package br.com.pooj.cotavia.app.usecases.payment;

import org.springframework.stereotype.Service;

import br.com.pooj.cotavia.api.dtos.request.CreatePaymentRequestDto;
import br.com.pooj.cotavia.api.dtos.response.PaymentResponseDto;
import br.com.pooj.cotavia.api.mappers.PaymentDtoMapper;
import br.com.pooj.cotavia.core.interfaces.payment.RegisterPaymentCase;
import br.com.pooj.cotavia.core.models.Payment;
import br.com.pooj.cotavia.core.models.Quote;
import br.com.pooj.cotavia.core.repositories.PaymentRepository;
import br.com.pooj.cotavia.core.repositories.QuoteRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegisterPaymentCaseImpl implements RegisterPaymentCase {
    private final PaymentRepository paymentRepository;
    private final QuoteRepository quoteRepository;

    private final PaymentDtoMapper paymentDtoMapper;

    @Override
    public PaymentResponseDto execute(CreatePaymentRequestDto request) {
        Quote quote = quoteRepository.findById(request.getQuoteId())
            .orElseThrow(() -> new RuntimeException("Cotação não encontrada"));

        Payment payment = paymentDtoMapper.toDomain(request, quote);

        Payment saved = paymentRepository.save(payment);

        return paymentDtoMapper.toResponse(saved);
    }
}
