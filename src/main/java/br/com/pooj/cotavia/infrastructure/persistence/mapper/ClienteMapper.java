package br.com.pooj.cotavia.infrastructure.persistence.mapper;

import br.com.pooj.cotavia.domain.model.Cliente;
import br.com.pooj.cotavia.infrastructure.persistence.entity.ClienteEntity;

public class ClienteMapper {
    public static Cliente toDomain(ClienteEntity entity) {
        return new Cliente(entity.getId(), entity.getNome(), entity.getEmail(), entity.getTelefone(), entity.getDocumento());
    }

    public static ClienteEntity toEntity(Cliente cliente) {
        return new ClienteEntity(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.getDocumento());
    }
}
