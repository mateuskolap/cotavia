package br.com.pooj.cotavia.infra.persistence.mappers;

import org.springframework.stereotype.Component;

import br.com.pooj.cotavia.core.models.Customer;
import br.com.pooj.cotavia.infra.persistence.entities.CustomerEntity;

@Component
public class CustomerMapper {
    public CustomerEntity toEntity(Customer c) {
        if (c == null) {
            return null;
        }
        CustomerEntity entity = new CustomerEntity();
        entity.setId(c.getId());
        entity.setName(c.getName());
        entity.setEmail(c.getEmail());
        entity.setPhoneNumber(c.getPhoneNumber());
        entity.setDocument(c.getDocument());
        return entity;
    }

    public Customer toModel(CustomerEntity e) {
        if (e == null) {
            return null;
        }
        Customer model = new Customer();
        model.setId(e.getId());
        model.setName(e.getName());
        model.setEmail(e.getEmail());
        model.setPhoneNumber(e.getPhoneNumber());
        model.setDocument(e.getDocument());
        return model;
    }
}
