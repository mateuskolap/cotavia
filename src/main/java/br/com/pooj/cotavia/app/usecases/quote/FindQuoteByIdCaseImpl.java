package br.com.pooj.cotavia.app.usecases.quote;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.pooj.cotavia.core.interfaces.quote.FindQuoteByIdCase;
import br.com.pooj.cotavia.core.models.Quote;
import br.com.pooj.cotavia.core.repositories.QuoteRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FindQuoteByIdCaseImpl implements FindQuoteByIdCase {
    private final QuoteRepository quoteRepository;

    @Override
    public Optional<Quote> execute(Long id) {
        return quoteRepository.findById(id);
    }
}
