package br.com.pooj.cotavia.api.dtos.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DestinationResponseDTO {
    private Long id;
    private String name;
    private String description;
    private String address;
    private BigDecimal pricePerPerson;
}
