package br.com.pooj.cotavia.core.interfaces.discount;

import br.com.pooj.cotavia.api.dtos.request.CreateDiscountRequestDto;
import br.com.pooj.cotavia.api.dtos.response.DiscountResponseDto;

public interface UpdateDiscountCase {
    DiscountResponseDto execute(Long id, CreateDiscountRequestDto updatedDiscount);
}
