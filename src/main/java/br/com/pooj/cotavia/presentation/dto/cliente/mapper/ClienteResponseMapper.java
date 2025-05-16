package br.com.pooj.cotavia.presentation.dto.cliente.mapper;

import br.com.pooj.cotavia.domain.model.Cliente;
import br.com.pooj.cotavia.presentation.dto.cliente.ClienteResponse;

public class ClienteResponseMapper {
    public static ClienteResponse toResponse(Cliente cliente) {
        if (cliente == null) return null;

        return new ClienteResponse(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.getDocumento());
    }
}
