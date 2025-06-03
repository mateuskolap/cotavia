package br.com.pooj.cotavia.core.interfaces.quote;

import br.com.pooj.cotavia.core.models.Quote;

public interface CreateQuoteCase {
    Quote execute(Quote quote);
}
