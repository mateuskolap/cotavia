package br.com.pooj.cotavia.core.interfaces.payment;

import br.com.pooj.cotavia.api.dtos.request.CreatePaymentRequestDto;
import br.com.pooj.cotavia.api.dtos.response.PaymentResponseDto;

public interface RegisterPaymentCase {
    PaymentResponseDto execute(CreatePaymentRequestDto request);
}
