package br.com.pooj.cotavia.app.usecases.quote;

import org.springframework.stereotype.Service;

import br.com.pooj.cotavia.api.dtos.request.CreateQuoteRequestDto;
import br.com.pooj.cotavia.api.dtos.response.QuoteResponseDto;
import br.com.pooj.cotavia.api.mappers.QuoteDtoMapper;
import br.com.pooj.cotavia.core.interfaces.quote.CreateQuoteCase;
import br.com.pooj.cotavia.core.models.Customer;
import br.com.pooj.cotavia.core.models.Destination;
import br.com.pooj.cotavia.core.models.Quote;
import br.com.pooj.cotavia.core.repositories.CustomerRepository;
import br.com.pooj.cotavia.core.repositories.DestinationRepository;
import br.com.pooj.cotavia.core.repositories.QuoteRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CreateQuoteCaseImpl implements CreateQuoteCase {
    private final QuoteRepository quoteRepository;
    private final DestinationRepository destinationRepository;
    private final CustomerRepository customerRepository;

    private final QuoteDtoMapper quoteDtoMapper;

    @Override
    public QuoteResponseDto execute(CreateQuoteRequestDto request) {
        Customer customer = customerRepository.findById(request.getCustomerId())
            .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Destination destination = destinationRepository.findById(request.getDestinationId())
            .orElseThrow(() -> new RuntimeException("Destino não encontrado"));

        Quote quote = quoteDtoMapper.toDomain(request, customer, destination);
        quote.calculatePrice();
        
        Quote saved = quoteRepository.save(quote);

        return quoteDtoMapper.toResponse(saved);
    }
}
