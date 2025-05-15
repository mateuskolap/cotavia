package br.com.pooj.cotavia.infrastructure.persistence.mapper;

import br.com.pooj.cotavia.domain.model.Cotacao;
import br.com.pooj.cotavia.infrastructure.persistence.entity.CotacaoEntity;

public class CotacaoMapper {
    public static Cotacao toDomain(CotacaoEntity entity) {
        return new Cotacao(entity.getId(), entity.getValorPago(), entity.getStatus(), entity.getDataPagamento(), ClienteMapper.toDomain(entity.getCliente());
    }

}
