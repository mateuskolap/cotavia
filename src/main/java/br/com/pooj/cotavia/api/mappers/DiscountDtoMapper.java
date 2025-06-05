package br.com.pooj.cotavia.api.mappers;

import br.com.pooj.cotavia.api.dtos.request.CreateDiscountRequestDto;
import br.com.pooj.cotavia.api.dtos.response.DiscountResponseDto;
import br.com.pooj.cotavia.core.models.Discount;
import br.com.pooj.cotavia.core.models.Quote;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DiscountDtoMapper {
    public Discount toDomain(CreateDiscountRequestDto request, Quote quote) {
        if (request == null || quote == null) {
            return null;
        }
        Discount discount = new Discount();

        discount.setQuote(quote);
        discount.setDiscountAmount(request.getDiscountAmount());
        discount.setDescription(request.getDescription());
        discount.setDate(LocalDateTime.now());

        return discount;
    }

    public DiscountResponseDto toResponse(Discount domain) {
        if (domain == null) {
            return null;
        }

        DiscountResponseDto dto = new DiscountResponseDto();
        dto.setId(domain.getId());

        if (domain.getQuote() != null) {
            dto.setQuoteId(domain.getQuote().getId());
        }

        dto.setDiscountAmount(domain.getDiscountAmount());
        dto.setDescription(domain.getDescription());
        dto.setDate(domain.getDate());

        return dto;
    }
}
