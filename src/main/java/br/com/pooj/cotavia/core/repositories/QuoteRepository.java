package br.com.pooj.cotavia.core.repositories;

import java.util.List;
import java.util.Optional;

import br.com.pooj.cotavia.core.models.Quote;

public interface QuoteRepository {
    Quote save(Quote quote);
    List<Quote> findAll();
    Optional<Quote> findById(Long id);
    void deleteById(Long id);
    boolean existsById(Long id);
}
