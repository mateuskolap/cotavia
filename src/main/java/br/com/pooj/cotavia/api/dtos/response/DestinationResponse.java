package br.com.pooj.cotavia.api.dtos.response;

import java.math.BigDecimal;

import br.com.pooj.cotavia.core.models.Address;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DestinationResponse {
    private String id;
    private String name;
    private String description;
    private Address address;
    private BigDecimal pricePerPerson;
}
