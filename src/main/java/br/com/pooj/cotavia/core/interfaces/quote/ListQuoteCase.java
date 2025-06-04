package br.com.pooj.cotavia.core.interfaces.quote;

import java.util.List;

import br.com.pooj.cotavia.api.dtos.response.QuoteResponseDto;

public interface ListQuoteCase {
    List<QuoteResponseDto> execute();
}
