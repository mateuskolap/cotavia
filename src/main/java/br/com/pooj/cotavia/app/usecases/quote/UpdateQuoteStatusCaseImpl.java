package br.com.pooj.cotavia.app.usecases.quote;

import org.springframework.stereotype.Service;

import br.com.pooj.cotavia.core.enums.QuoteStatus;
import br.com.pooj.cotavia.core.interfaces.quote.UpdateQuoteStatusCase;
import br.com.pooj.cotavia.core.models.Quote;
import br.com.pooj.cotavia.core.repositories.QuoteRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UpdateQuoteStatusCaseImpl implements UpdateQuoteStatusCase {
    private final QuoteRepository quoteRepository;

    @Override
    public void execute(Long quoteId, QuoteStatus newStatus) {
        Quote quote = quoteRepository.findById(quoteId)
            .orElseThrow(() -> new RuntimeException("Cotacao não encontrada"));

        quote.setStatus(newStatus);
        quoteRepository.save(quote);
    }
}
