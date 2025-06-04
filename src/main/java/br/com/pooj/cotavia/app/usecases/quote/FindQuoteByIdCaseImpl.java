package br.com.pooj.cotavia.app.usecases.quote;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.pooj.cotavia.api.dtos.response.QuoteResponseDto;
import br.com.pooj.cotavia.api.mappers.QuoteDtoMapper;
import br.com.pooj.cotavia.core.interfaces.quote.FindQuoteByIdCase;
import br.com.pooj.cotavia.core.repositories.QuoteRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FindQuoteByIdCaseImpl implements FindQuoteByIdCase {
    private final QuoteRepository quoteRepository;

    private final QuoteDtoMapper quoteDtoMapper;

    @Override
    public Optional<QuoteResponseDto> execute(Long id) {
        return quoteRepository.findById(id)
            .map(quoteDtoMapper::toResponse);
    }
}
