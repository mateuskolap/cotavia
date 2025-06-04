package br.com.pooj.cotavia.api.dtos.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.pooj.cotavia.core.enums.QuoteStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuoteResponseDto {
    private Long id;

    private Long customerId;
    private String customerName;

    private Long destinationId;
    private String destinationName;
    
    private LocalDateTime date;
    private Integer numberOfTravellers;
    private BigDecimal price;
    private QuoteStatus status;
}
