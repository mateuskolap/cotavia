package br.com.pooj.cotavia.core.interfaces.quote;

import br.com.pooj.cotavia.api.dtos.request.CreateQuoteRequestDto;
import br.com.pooj.cotavia.api.dtos.response.QuoteResponseDto;

public interface CreateQuoteCase {
    QuoteResponseDto execute(CreateQuoteRequestDto quote);
}
