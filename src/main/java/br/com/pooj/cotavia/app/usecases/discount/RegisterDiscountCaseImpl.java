package br.com.pooj.cotavia.app.usecases.discount;

import br.com.pooj.cotavia.api.dtos.request.CreateDiscountRequestDto;
import br.com.pooj.cotavia.api.dtos.response.DiscountResponseDto;
import br.com.pooj.cotavia.api.mappers.DiscountDtoMapper;
import br.com.pooj.cotavia.core.models.Quote;
import br.com.pooj.cotavia.core.repositories.QuoteRepository;
import org.springframework.stereotype.Service;

import br.com.pooj.cotavia.core.interfaces.discount.RegisterDiscountCase;
import br.com.pooj.cotavia.core.models.Discount;
import br.com.pooj.cotavia.core.repositories.DiscountRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegisterDiscountCaseImpl implements RegisterDiscountCase {
    private final DiscountRepository discountRepository;
    private final QuoteRepository quoteRepository;

    private final DiscountDtoMapper discountDtoMapper;

    @Override
    public DiscountResponseDto execute(CreateDiscountRequestDto request) {
        Quote quote = quoteRepository.findById(request.getQuoteId())
                .orElseThrow(() -> new RuntimeException("Cotação não encontrada"));

        Discount discount = discountDtoMapper.toDomain(request, quote);

        Discount saved = discountRepository.save(discount);
        return discountDtoMapper.toResponse(saved);
    }
}
