package br.com.pooj.cotavia.api.dtos.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.pooj.cotavia.core.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponseDto {
    private Long id;

    private Long quoteId;

    private BigDecimal amountPaid;
    private PaymentStatus status;
    private LocalDateTime date;
}
