package br.com.pooj.cotavia.presentation.dto.destino.mapper;

import br.com.pooj.cotavia.domain.model.Destino;
import br.com.pooj.cotavia.presentation.dto.destino.AtualizarDestinoRequest;
import br.com.pooj.cotavia.presentation.dto.destino.CadastrarDestinoRequest;

public class DestinoRequestMapper {
    public static Destino toDomain(CadastrarDestinoRequest request) {
        if (request == null) return null;

        return new Destino(null, request.getNome(), request.getDescricao(), request.getLocalizacao(), request.getPrecoPorPessoa());
    }

    public static Destino toDomain(AtualizarDestinoRequest request) {
        if (request == null) return null;

        return new Destino(null, request.getNome(), request.getDescricao(), request.getLocalizacao(), request.getPrecoPorPessoa());
    }
}
