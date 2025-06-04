package br.com.pooj.cotavia.api.dtos.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CreateDestinationRequestDto {
    @NotBlank(message = "O nome é obrigatório")
    private String name;
    
    private String description;

    @NotBlank(message = "O endereço é obrigatório")
    private String address;

    @NotEmpty(message = "O preço por pessoa é obrigatório")
    private BigDecimal pricePerPerson;
}
