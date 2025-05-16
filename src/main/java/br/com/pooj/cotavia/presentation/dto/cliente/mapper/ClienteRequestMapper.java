package br.com.pooj.cotavia.presentation.dto.cliente.mapper;

import br.com.pooj.cotavia.domain.model.Cliente;
import br.com.pooj.cotavia.presentation.dto.cliente.AtualizarClienteRequest;
import br.com.pooj.cotavia.presentation.dto.cliente.CadastrarClienteRequest;

public class ClienteRequestMapper {
    public static Cliente toDomain(CadastrarClienteRequest request) {
        if (request == null) return null;

        return new Cliente(null, request.getNome(), request.getEmail(), request.getTelefone(), request.getDocumento());
    }

    public static Cliente toDomain(AtualizarClienteRequest request) {
        if (request == null) return null;

        return new Cliente(null, request.getNome(), request.getEmail(), request.getTelefone(), request.getDocumento());
    }
}
