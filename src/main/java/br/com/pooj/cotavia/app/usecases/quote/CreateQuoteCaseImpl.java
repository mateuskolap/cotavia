package br.com.pooj.cotavia.app.usecases.quote;

import org.springframework.stereotype.Service;

import br.com.pooj.cotavia.core.interfaces.quote.CreateQuoteCase;
import br.com.pooj.cotavia.core.models.Quote;
import br.com.pooj.cotavia.core.repositories.QuoteRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CreateQuoteCaseImpl implements CreateQuoteCase {
    private final QuoteRepository quoteRepository;

    @Override
    public Quote execute(Quote quote) {
        return quoteRepository.save(quote);
    }
}
