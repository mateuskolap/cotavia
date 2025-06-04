package br.com.pooj.cotavia.infra.persistence.mappers;

import org.springframework.stereotype.Component;

import br.com.pooj.cotavia.core.models.Quote;
import br.com.pooj.cotavia.infra.persistence.entities.QuoteEntity;

@Component
public class QuoteMapper {

    private final CustomerMapper customerMapper;
    private final DestinationMapper destinationMapper;

    public QuoteMapper(CustomerMapper customerMapper, DestinationMapper destinationMapper) {
        this.customerMapper = customerMapper;
        this.destinationMapper = destinationMapper;
    }

    public QuoteEntity toEntity(Quote q) {
        if (q == null) {
            return null;
        }
        QuoteEntity entity = new QuoteEntity();
        entity.setId(q.getId());
        entity.setCustomer(customerMapper.toEntity(q.getCustomer()));
        entity.setDestination(destinationMapper.toEntity(q.getDestination()));
        entity.setDate(q.getDate());
        entity.setNumberOfTravellers(q.getNumberOfTravellers());
        entity.setPrice(q.getPrice());
        entity.setStatus(q.getStatus());
        return entity;
    }

    public Quote toModel(QuoteEntity e) {
        if (e == null) {
            return null;
        }
        Quote model = new Quote();
        model.setId(e.getId());
        model.setCustomer(customerMapper.toModel(e.getCustomer()));
        model.setDestination(destinationMapper.toModel(e.getDestination()));
        model.setDate(e.getDate());
        model.setNumberOfTravellers(e.getNumberOfTravellers());
        model.setPrice(e.getPrice());
        model.setStatus(e.getStatus());
        return model;
    }
}