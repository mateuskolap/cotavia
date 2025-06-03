package br.com.pooj.cotavia.infra.persistence.repositories.quote;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.pooj.cotavia.core.models.Quote;
import br.com.pooj.cotavia.core.repositories.QuoteRepository;
import br.com.pooj.cotavia.infra.persistence.entities.QuoteEntity;
import br.com.pooj.cotavia.infra.persistence.mappers.QuoteMapper;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class QuoteRepositoryImpl implements QuoteRepository {
    private final SpringQuoteJpaRepository jpaRepository;
    private final QuoteMapper quoteMapper;

    @Override
    public Quote save(Quote quote) {
        QuoteEntity entity = quoteMapper.toEntity(quote);
        QuoteEntity saved = jpaRepository.save(entity);

        return quoteMapper.toModel(saved);
    }

    @Override
    public List<Quote> findAll() {
        return jpaRepository.findAll()
                            .stream()
                            .map(quoteMapper::toModel)
                            .collect(Collectors.toList());
    }

    @Override
    public Optional<Quote> findById(Long id) {
        return jpaRepository.findById(id)
                            .map(quoteMapper::toModel);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaRepository.existsById(id);
    }
}
