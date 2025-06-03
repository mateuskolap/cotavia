package br.com.pooj.cotavia.api.dtos.request;

import java.math.BigDecimal;

import br.com.pooj.cotavia.core.models.Address;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateDestinationRequest {
    @NotBlank(message = "O nome do destino é obrigatório")
    private String name;

    private String description;

    @Valid
    private Address address;

    @NotBlank(message = "O campo 'price per person' é obrigatório")
    private BigDecimal pricePerPerson;
}
