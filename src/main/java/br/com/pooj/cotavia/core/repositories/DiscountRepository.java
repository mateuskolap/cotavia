package br.com.pooj.cotavia.core.repositories;

import java.util.List;
import java.util.Optional;

import br.com.pooj.cotavia.core.models.Discount;

public interface DiscountRepository {
    Discount save(Discount discount);
    List<Discount> findAll();
    Optional<Discount> findById(Long id);
    List<Discount> findAllByQuote_Id(Long quoteId);
    void deleteById(Long id);
    boolean existsById(Long id);
}
