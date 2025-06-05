package br.com.pooj.cotavia.core.interfaces.discount;

import java.util.Optional;

import br.com.pooj.cotavia.api.dtos.response.DiscountResponseDto;

public interface FindDiscountByIdCase {
    Optional<DiscountResponseDto> execute(Long id);
}
