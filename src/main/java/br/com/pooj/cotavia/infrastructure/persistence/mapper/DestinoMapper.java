package br.com.pooj.cotavia.infrastructure.persistence.mapper;

import br.com.pooj.cotavia.domain.model.Destino;
import br.com.pooj.cotavia.infrastructure.persistence.entity.DestinoEntity;

public class DestinoMapper {
    public static Destino toDomain(DestinoEntity entity) {
        return new Destino(entity.getId(), entity.getNome(), entity.getDescricao(), entity.getLocalizacao(), entity.getPrecoPorPessoa());
    }

    public static DestinoEntity toEntity(Destino destino) {
        return new DestinoEntity(destino.getId(), destino.getNome(), destino.getDescricao(), destino.getLocalizacao(), destino.getPrecoPorPessoa());
    }
}
