package br.com.pooj.cotavia.core.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Discount {
    private Long id;
    private Quote quote;
    private BigDecimal discountAmount;
    private String description;
    private LocalDateTime date;
}
