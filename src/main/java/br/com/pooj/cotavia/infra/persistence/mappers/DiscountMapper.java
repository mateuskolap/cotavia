package br.com.pooj.cotavia.infra.persistence.mappers;

import org.springframework.stereotype.Component;

import br.com.pooj.cotavia.core.models.Discount;
import br.com.pooj.cotavia.infra.persistence.entities.DiscountEntity;

@Component
public class DiscountMapper {

    private final QuoteMapper quoteMapper;

    public DiscountMapper(QuoteMapper quoteMapper) {
        this.quoteMapper = quoteMapper;
    }

    public DiscountEntity toEntity(Discount d) {
        if (d == null) {
            return null;
        }
        DiscountEntity entity = new DiscountEntity();
        entity.setId(d.getId());
        entity.setQuote(quoteMapper.toEntity(d.getQuote()));
        entity.setDiscountAmount(d.getDiscountAmount());
        entity.setDescription(d.getDescription());
        entity.setDate(d.getDate());
        return entity;
    }

    public Discount toModel(DiscountEntity e) {
        if (e == null) {
            return null;
        }
        Discount model = new Discount();
        model.setId(e.getId());
        model.setQuote(quoteMapper.toModel(e.getQuote()));
        model.setDiscountAmount(e.getDiscountAmount());
        model.setDescription(e.getDescription());
        model.setDate(e.getDate());
        return model;
    }
}
