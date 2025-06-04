package br.com.pooj.cotavia.core.models;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Destination {
    private Long id;
    private String name;
    private String description;
    private String address;
    private BigDecimal pricePerPerson;
}