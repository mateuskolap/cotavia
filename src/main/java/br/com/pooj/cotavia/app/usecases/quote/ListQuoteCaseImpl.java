package br.com.pooj.cotavia.app.usecases.quote;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.pooj.cotavia.core.interfaces.quote.ListQuoteCase;
import br.com.pooj.cotavia.core.models.Quote;
import br.com.pooj.cotavia.core.repositories.QuoteRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ListQuoteCaseImpl implements ListQuoteCase {
    private final QuoteRepository quoteRepository;

    public List<Quote> execute() {
        return quoteRepository.findAll();
    }
}
