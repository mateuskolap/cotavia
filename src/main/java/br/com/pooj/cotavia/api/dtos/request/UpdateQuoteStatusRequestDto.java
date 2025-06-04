package br.com.pooj.cotavia.api.dtos.request;

import br.com.pooj.cotavia.core.enums.QuoteStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateQuoteStatusRequestDto {
    @NotNull(message = "O status deve ser preenchido")
    private QuoteStatus status;
}
