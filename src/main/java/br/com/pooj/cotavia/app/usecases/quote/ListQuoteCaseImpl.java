package br.com.pooj.cotavia.app.usecases.quote;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.pooj.cotavia.api.dtos.response.QuoteResponseDto;
import br.com.pooj.cotavia.api.mappers.QuoteDtoMapper;
import br.com.pooj.cotavia.core.interfaces.quote.ListQuoteCase;
import br.com.pooj.cotavia.core.repositories.QuoteRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ListQuoteCaseImpl implements ListQuoteCase {
    private final QuoteRepository quoteRepository;

    private final QuoteDtoMapper quoteDtoMapper;

    public List<QuoteResponseDto> execute() {
        return quoteRepository.findAll()
            .stream()
            .map(quoteDtoMapper::toResponse)
            .collect(Collectors.toList());
    }
}
