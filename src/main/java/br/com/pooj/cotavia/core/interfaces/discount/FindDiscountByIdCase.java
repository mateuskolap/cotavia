package br.com.pooj.cotavia.core.interfaces.discount;

import java.util.Optional;

import br.com.pooj.cotavia.core.models.Discount;

public interface FindDiscountByIdCase {
    Optional<Discount> execute(Long id);
}
