package br.com.pooj.cotavia.infra.persistence.mappers;

import org.springframework.stereotype.Component;

import br.com.pooj.cotavia.core.models.Payment;
import br.com.pooj.cotavia.infra.persistence.entities.PaymentEntity;

@Component
public class PaymentMapper {

    private final QuoteMapper quoteMapper;

    public PaymentMapper(QuoteMapper quoteMapper) {
        this.quoteMapper = quoteMapper;
    }

    public PaymentEntity toEntity(Payment p) {
        if (p == null) {
            return null;
        }
        PaymentEntity entity = new PaymentEntity();
        entity.setId(p.getId());
        entity.setQuote(quoteMapper.toEntity(p.getQuote()));
        entity.setAmountPaid(p.getAmountPaid());
        entity.setStatus(p.getStatus());
        entity.setDate(p.getDate());
        return entity;
    }

    public Payment toModel(PaymentEntity e) {
        if (e == null) {
            return null;
        }
        Payment model = new Payment();
        model.setId(e.getId());
        model.setQuote(quoteMapper.toModel(e.getQuote()));
        model.setAmountPaid(e.getAmountPaid());
        model.setStatus(e.getStatus());
        model.setDate(e.getDate());
        return model;
    }
}
