package br.com.pooj.cotavia.core.interfaces.discount;

import java.util.List;

import br.com.pooj.cotavia.api.dtos.response.DiscountResponseDto;

public interface ListDiscountByQuoteCase {
    List<DiscountResponseDto> execute(Long quoteId);
}
