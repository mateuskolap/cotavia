package br.com.pooj.cotavia.app.usecases.discount;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.pooj.cotavia.core.interfaces.discount.FindDiscountByIdCase;
import br.com.pooj.cotavia.core.models.Discount;
import br.com.pooj.cotavia.core.repositories.DiscountRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FindDiscountByIdCaseImpl implements FindDiscountByIdCase {
    private final DiscountRepository discountRepository;

    @Override
    public Optional<Discount> execute(Long id) {
        return discountRepository.findById(id);
    }
}
