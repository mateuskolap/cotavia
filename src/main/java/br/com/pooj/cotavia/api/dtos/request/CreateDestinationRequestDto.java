package br.com.pooj.cotavia.api.dtos.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateDestinationRequestDto {
    @NotBlank(message = "O nome é obrigatório")
    private String name;
    
    private String description;

    @NotBlank(message = "O endereço é obrigatório")
    private String address;

    @DecimalMin(value = "0.0", inclusive = false, message = "O valor deve ser maior que 0")
    private BigDecimal pricePerPerson;
}
