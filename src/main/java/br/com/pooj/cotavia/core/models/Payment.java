package br.com.pooj.cotavia.core.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.pooj.cotavia.core.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    private Long id;
    private Quote quote;
    private BigDecimal amountPaid;
    private PaymentStatus status;
    private LocalDateTime date;
}
