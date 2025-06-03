package br.com.pooj.cotavia.core.interfaces.quote;

import java.util.Optional;

import br.com.pooj.cotavia.core.models.Quote;

public interface FindQuoteByIdCase {
    Optional<Quote> execute(Long id);
}
