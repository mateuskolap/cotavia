package br.com.pooj.cotavia.presentation.dto.destino.mapper;

import br.com.pooj.cotavia.domain.model.Destino;
import br.com.pooj.cotavia.presentation.dto.destino.DestinoResponse;

public class DestinoResponseMapper {
    public static DestinoResponse toResponse(Destino destino) {
        if (destino == null) return null;

        return new DestinoResponse(destino.getId(), destino.getNome(), destino.getDescricao(), destino.getLocalizacao(), destino.getPrecoPorPessoa());
    }
}
