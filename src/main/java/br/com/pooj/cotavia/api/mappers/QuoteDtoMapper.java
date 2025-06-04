package br.com.pooj.cotavia.api.mappers;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import br.com.pooj.cotavia.api.dtos.request.CreateQuoteRequestDto;
import br.com.pooj.cotavia.api.dtos.response.QuoteResponseDto;
import br.com.pooj.cotavia.core.enums.QuoteStatus;
import br.com.pooj.cotavia.core.models.Customer;
import br.com.pooj.cotavia.core.models.Destination;
import br.com.pooj.cotavia.core.models.Quote;

@Component
public class QuoteDtoMapper {
    public Quote toDomain(CreateQuoteRequestDto request, Customer customer, Destination destination) {
        if (request == null || customer == null || destination == null) {
            return null;
        }
        Quote quote = new Quote();
        
        quote.setCustomer(customer);
        quote.setDestination(destination);
        quote.setDate(LocalDateTime.now()); // Definido como agora
        quote.setNumberOfTravellers(request.getNumberOfTravellers());
        quote.setStatus(QuoteStatus.PENDENTE); // Status inicial padrão

        return quote;
    }

    public QuoteResponseDto toResponse(Quote domain) {
        if (domain == null) {
            return null;
        }

        QuoteResponseDto dto = new QuoteResponseDto();
        dto.setId(domain.getId());

        if (domain.getCustomer() != null) {
            dto.setCustomerId(domain.getCustomer().getId());
            dto.setCustomerName(domain.getCustomer().getName());
        }

        if (domain.getDestination() != null) {
            dto.setDestinationId(domain.getDestination().getId());
            dto.setDestinationName(domain.getDestination().getName());
        }

        dto.setDate(domain.getDate());
        dto.setNumberOfTravellers(domain.getNumberOfTravellers());
        dto.setPrice(domain.getPrice());
        dto.setStatus(domain.getStatus());

        return dto;
    }
}
