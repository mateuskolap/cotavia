package br.com.pooj.cotavia.core.interfaces.quote;

import br.com.pooj.cotavia.core.enums.QuoteStatus;

public interface UpdateQuoteStatusCase {
    void execute(Long quoteId, QuoteStatus newStatus);
}
