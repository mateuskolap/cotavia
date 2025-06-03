package br.com.pooj.cotavia.core.interfaces.discount;

import java.util.List;

import br.com.pooj.cotavia.core.models.Discount;

public interface ListDiscountByQuoteCase {
    List<Discount> execute(Long quoteId);
}
