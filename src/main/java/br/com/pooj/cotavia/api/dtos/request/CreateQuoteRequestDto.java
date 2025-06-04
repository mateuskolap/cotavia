package br.com.pooj.cotavia.api.dtos.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateQuoteRequestDto {
    @NotNull(message = "O id do cliente é obrigatório")
    private Long customerId;

    @NotNull(message = "O id do destino é obrigatório")
    private Long destinationId;

    @Min(value = 1, message = "É necessário ter pelo menos 1 pessoa")
    private Integer numberOfTravellers;
}
