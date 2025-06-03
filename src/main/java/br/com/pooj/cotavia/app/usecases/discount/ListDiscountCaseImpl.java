package br.com.pooj.cotavia.app.usecases.discount;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.pooj.cotavia.core.interfaces.discount.ListDiscountCase;
import br.com.pooj.cotavia.core.models.Discount;
import br.com.pooj.cotavia.core.repositories.DiscountRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ListDiscountCaseImpl implements ListDiscountCase {
    private final DiscountRepository discountRepository;

    @Override
    public List<Discount> execute() {
        return discountRepository.findAll();
    }
}
