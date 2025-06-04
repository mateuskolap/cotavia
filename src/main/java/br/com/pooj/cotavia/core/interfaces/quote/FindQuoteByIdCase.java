package br.com.pooj.cotavia.core.interfaces.quote;

import java.util.Optional;

import br.com.pooj.cotavia.api.dtos.response.QuoteResponseDto;

public interface FindQuoteByIdCase {
    Optional<QuoteResponseDto> execute(Long id);
}
