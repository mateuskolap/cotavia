package br.com.pooj.cotavia.core.interfaces.discount;

import br.com.pooj.cotavia.core.models.Discount;

public interface UpdateDiscountCase {
    Discount execute(Long id, Discount updatedDiscount);
}
