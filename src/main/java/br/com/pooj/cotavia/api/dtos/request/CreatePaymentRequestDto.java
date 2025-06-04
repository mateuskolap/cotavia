package br.com.pooj.cotavia.api.dtos.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreatePaymentRequestDto {
    @NotNull(message = "O id da cotação é obrigatório")
    private Long quoteId;

    @Min(value = 0, message = "O valor precisa ser maior que 0")
    private BigDecimal amountPaid;
}
