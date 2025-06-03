package br.com.pooj.cotavia.app.usecases.discount;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.pooj.cotavia.core.interfaces.discount.ListDiscountByQuoteCase;
import br.com.pooj.cotavia.core.models.Discount;
import br.com.pooj.cotavia.core.repositories.DiscountRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ListDiscountByQuoteCaseImpl implements ListDiscountByQuoteCase {
    private final DiscountRepository discountRepository;

    @Override
    public List<Discount> execute(Long quoteId) {
        return discountRepository.findAllByQuote_Id(quoteId);
    }
}
