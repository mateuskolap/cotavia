package br.com.pooj.cotavia.app.usecases.discount;

import org.springframework.stereotype.Service;

import br.com.pooj.cotavia.core.interfaces.discount.UpdateDiscountCase;
import br.com.pooj.cotavia.core.models.Discount;
import br.com.pooj.cotavia.core.repositories.DiscountRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UpdateDiscountCaseImpl implements UpdateDiscountCase {
    private final DiscountRepository discountRepository;

    @Override
    public Discount execute(Long id, Discount updatedDiscount) {
        Discount existing = discountRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Desconto não encontrado"));

        existing.setQuote(updatedDiscount.getQuote());
        existing.setDiscountAmount(updatedDiscount.getDiscountAmount());
        existing.setDescription(updatedDiscount.getDescription());
        existing.setDate(updatedDiscount.getDate());

        return discountRepository.save(existing);
    }
}
