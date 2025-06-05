package br.com.pooj.cotavia.app.usecases.discount;

import br.com.pooj.cotavia.api.dtos.request.CreateDiscountRequestDto;
import br.com.pooj.cotavia.api.dtos.response.DiscountResponseDto;
import br.com.pooj.cotavia.api.mappers.DiscountDtoMapper;
import br.com.pooj.cotavia.core.models.Quote;
import br.com.pooj.cotavia.core.repositories.QuoteRepository;
import org.springframework.stereotype.Service;

import br.com.pooj.cotavia.core.interfaces.discount.UpdateDiscountCase;
import br.com.pooj.cotavia.core.models.Discount;
import br.com.pooj.cotavia.core.repositories.DiscountRepository;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class UpdateDiscountCaseImpl implements UpdateDiscountCase {
    private final DiscountRepository discountRepository;
    private final QuoteRepository quoteRepository;

    private final DiscountDtoMapper discountDtoMapper;

    @Override
    public DiscountResponseDto execute(Long id, CreateDiscountRequestDto updatedDiscount) {
        Discount existing = discountRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Desconto não encontrado"));

        Quote existingQuote = quoteRepository.findById(updatedDiscount.getQuoteId())
            .orElseThrow(() -> new RuntimeException("Cotação não encontrada"));

        existing.setQuote(existingQuote);
        existing.setDiscountAmount(updatedDiscount.getDiscountAmount());
        existing.setDescription(updatedDiscount.getDescription());
        existing.setDate(LocalDateTime.now());

        Discount updated = discountRepository.save(existing);

        return discountDtoMapper.toResponse(updated);
    }
}
