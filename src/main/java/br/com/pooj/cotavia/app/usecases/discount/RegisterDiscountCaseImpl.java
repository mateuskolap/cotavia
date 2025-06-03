package br.com.pooj.cotavia.app.usecases.discount;

import org.springframework.stereotype.Service;

import br.com.pooj.cotavia.core.interfaces.discount.RegisterDiscountCase;
import br.com.pooj.cotavia.core.models.Discount;
import br.com.pooj.cotavia.core.repositories.DiscountRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegisterDiscountCaseImpl implements RegisterDiscountCase {
    private final DiscountRepository discountRepository;

    @Override
    public Discount execute(Discount discount) {
        return discountRepository.save(discount);
    }
}
