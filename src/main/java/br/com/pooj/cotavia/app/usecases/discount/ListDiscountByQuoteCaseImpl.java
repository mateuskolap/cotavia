package br.com.pooj.cotavia.app.usecases.discount;

import java.util.List;
import java.util.stream.Collectors;

import br.com.pooj.cotavia.api.dtos.response.DiscountResponseDto;
import br.com.pooj.cotavia.api.mappers.DiscountDtoMapper;
import org.springframework.stereotype.Service;

import br.com.pooj.cotavia.core.interfaces.discount.ListDiscountByQuoteCase;
import br.com.pooj.cotavia.core.repositories.DiscountRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ListDiscountByQuoteCaseImpl implements ListDiscountByQuoteCase {
    private final DiscountRepository discountRepository;

    private final DiscountDtoMapper discountDtoMapper;

    @Override
    public List<DiscountResponseDto> execute(Long quoteId) {
        return discountRepository.findAllByQuote_Id(quoteId)
                .stream()
                .map(discountDtoMapper::toResponse)
                .collect(Collectors.toList());
    }
}
