package br.com.pooj.cotavia.infra.persistence.mappers;

import org.springframework.stereotype.Component;

import br.com.pooj.cotavia.core.models.Destination;
import br.com.pooj.cotavia.infra.persistence.entities.DestinationEntity;

@Component
public class DestinationMapper {
    public DestinationEntity toEntity(Destination d) {
        if (d == null) {
            return null;
        }
        DestinationEntity entity = new DestinationEntity();
        entity.setId(d.getId());
        entity.setName(d.getName());
        entity.setDescription(d.getDescription());
        entity.setAddress(d.getAddress());
        entity.setPricePerPerson(d.getPricePerPerson());
        return entity;
    }

    public Destination toModel(DestinationEntity e) {
        if (e == null) {
            return null;
        }
        Destination model = new Destination();
        model.setId(e.getId());
        model.setName(e.getName());
        model.setDescription(e.getDescription());
        model.setAddress(e.getAddress());
        model.setPricePerPerson(e.getPricePerPerson());
        return model;
    }
}
