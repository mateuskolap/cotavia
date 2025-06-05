package br.com.pooj.cotavia.api.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscountResponseDto {
    private Long id;
    private Long quoteId;
    private BigDecimal discountAmount;
    private String description;
    private LocalDateTime date;
}
