package br.com.pooj.cotavia.api.dtos.request;

import br.com.pooj.cotavia.core.enums.PaymentStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdatePaymentStatusRequestDto {
    @NotNull(message = "O status deve ser preenchido")
    private PaymentStatus status;
}
