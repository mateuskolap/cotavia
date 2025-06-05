package br.com.pooj.cotavia.app.usecases.discount;

import java.util.Optional;

import br.com.pooj.cotavia.api.dtos.response.DiscountResponseDto;
import br.com.pooj.cotavia.api.mappers.DiscountDtoMapper;
import br.com.pooj.cotavia.core.models.Quote;
import br.com.pooj.cotavia.core.repositories.QuoteRepository;
import org.springframework.stereotype.Service;

import br.com.pooj.cotavia.core.interfaces.discount.FindDiscountByIdCase;
import br.com.pooj.cotavia.core.repositories.DiscountRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FindDiscountByIdCaseImpl implements FindDiscountByIdCase {
    private final DiscountRepository discountRepository;

    private final DiscountDtoMapper discountDtoMapper;

    @Override
    public Optional<DiscountResponseDto> execute(Long id) {
        return discountRepository.findById(id)
                .map(discountDtoMapper::toResponse);
    }
}
