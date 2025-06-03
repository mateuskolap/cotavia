package br.com.pooj.cotavia.infra.persistence.repositories.discount;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.pooj.cotavia.core.models.Discount;
import br.com.pooj.cotavia.core.repositories.DiscountRepository;
import br.com.pooj.cotavia.infra.persistence.entities.DiscountEntity;
import br.com.pooj.cotavia.infra.persistence.mappers.DiscountMapper;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class DiscountRepositoryImpl implements DiscountRepository {
    private final SpringDiscountJpaRepository jpaRepository;
    private final DiscountMapper discountMapper;

    @Override
    public Discount save(Discount discount) {
        DiscountEntity entity = discountMapper.toEntity(discount);
        DiscountEntity saved = jpaRepository.save(entity);

        return discountMapper.toModel(saved);
    }

    @Override
    public List<Discount> findAll() {
        return jpaRepository.findAll()
                            .stream()
                            .map(discountMapper::toModel)
                            .collect(Collectors.toList());
    }

    @Override
    public Optional<Discount> findById(Long id) {
        return jpaRepository.findById(id)
                            .map(discountMapper::toModel);
    }

    @Override
    public List<Discount> findAllByQuote_Id(Long quoteId) {
        return jpaRepository.findAllByQuote_Id(quoteId)
                            .stream()
                            .map(discountMapper::toModel)
                            .collect(Collectors.toList());
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