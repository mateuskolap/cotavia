package br.com.pooj.cotavia.core.models;

import br.com.pooj.cotavia.core.enums.QuoteStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quote {
    private Long id;
    private Customer customer;
    private Destination destination;
    private LocalDateTime date;
    private Integer numberOfTravellers;
    private BigDecimal price;
    private QuoteStatus status;

    public void calculatePrice() {
        this.price = destination.getPricePerPerson().multiply(BigDecimal.valueOf(numberOfTravellers));
    }
}