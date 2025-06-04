package br.com.pooj.cotavia.api.mappers;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import br.com.pooj.cotavia.api.dtos.request.CreatePaymentRequestDto;
import br.com.pooj.cotavia.api.dtos.response.PaymentResponseDto;
import br.com.pooj.cotavia.core.enums.PaymentStatus;
import br.com.pooj.cotavia.core.models.Payment;
import br.com.pooj.cotavia.core.models.Quote;

@Component
public class PaymentDtoMapper {
    public Payment toDomain(CreatePaymentRequestDto request, Quote quote) {
        if (request == null || quote == null) {
            return null;
        }
        Payment payment = new Payment();

        payment.setQuote(quote);
        payment.setAmountPaid(request.getAmountPaid());
        payment.setStatus(PaymentStatus.PENDENTE);
        payment.setDate(LocalDateTime.now());

        return payment;
    }

    public PaymentResponseDto toResponse(Payment domain) {
        if (domain == null) {
            return null;
        }

        PaymentResponseDto dto = new PaymentResponseDto();
        dto.setId(domain.getId());

        if (domain.getQuote() != null) {
            dto.setQuoteId(domain.getQuote().getId());
        }

        dto.setAmountPaid(domain.getAmountPaid());
        dto.setStatus(domain.getStatus());
        dto.setDate(domain.getDate());

        return dto;
    }
}
