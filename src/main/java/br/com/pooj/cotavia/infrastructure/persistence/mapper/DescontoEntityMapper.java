package br.com.pooj.cotavia.infrastructure.persistence.mapper;

import br.com.pooj.cotavia.domain.model.Desconto;
import br.com.pooj.cotavia.infrastructure.persistence.entity.DescontoEntity;

public class DescontoEntityMapper {
    public static Desconto toDomain(DescontoEntity entity) {
        return new Desconto(entity.getId(), entity.getValorDesconto(), entity.getDescricao(), entity.getDataAplicacao(), CotacaoEntityMapper.toDomain(entity.getCotacao()));
    }

    public static DescontoEntity toEntity(Desconto desconto) {
        return new DescontoEntity(desconto.getId(), desconto.getDescricao(), desconto.getValorDesconto(), desconto.getDataAplicacao(), CotacaoEntityMapper.toEntity(desconto.getCotacao()));
    }
}
