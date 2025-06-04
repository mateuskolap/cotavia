package br.com.pooj.cotavia.core.interfaces.payment;

import java.util.Optional;

import br.com.pooj.cotavia.api.dtos.response.PaymentResponseDto;

public interface FindPaymentByIdCase {
    Optional<PaymentResponseDto> execute(Long id);
}
