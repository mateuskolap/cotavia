package br.com.pooj.cotavia.app.usecases.discount;

import org.springframework.stereotype.Service;

import br.com.pooj.cotavia.core.interfaces.discount.RemoveDiscountCase;
import br.com.pooj.cotavia.core.repositories.DiscountRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RemoveDiscountCaseImpl implements RemoveDiscountCase {
    private final DiscountRepository discountRepository;

    @Override
    public void execute(Long id) {
        if (!discountRepository.existsById(id)) {
            throw new RuntimeException("Desconto não encontrado");
        }

        discountRepository.deleteById(id);
    }
}
