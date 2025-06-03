package br.com.pooj.cotavia.app.usecases.quote;

import org.springframework.stereotype.Service;

import br.com.pooj.cotavia.core.interfaces.quote.DeleteQuoteByIdCase;
import br.com.pooj.cotavia.core.repositories.QuoteRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DeleteQuoteByIdCaseImpl implements DeleteQuoteByIdCase {
    private final QuoteRepository quoteRepository;

    @Override
    public void execute(Long id) {
        if (!quoteRepository.existsById(id)) {
            throw new RuntimeException("Cotação não encontrada");
        }

        quoteRepository.deleteById(id);
    }
}
