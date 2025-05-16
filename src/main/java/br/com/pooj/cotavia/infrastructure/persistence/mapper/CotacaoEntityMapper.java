package br.com.pooj.cotavia.infrastructure.persistence.mapper;

import br.com.pooj.cotavia.domain.model.Cotacao;
import br.com.pooj.cotavia.infrastructure.persistence.entity.CotacaoEntity;

public class CotacaoEntityMapper {
    public static Cotacao toDomain(CotacaoEntity entity) {
        return new Cotacao(entity.getId(), entity.getValorPago(), entity.getStatus(), entity.getDataPagamento(), ClienteEntityMapper.toDomain(entity.getCliente()), DestinoEntityMapper.toDomain(entity.getDestino()));
    }

    public static CotacaoEntity toEntity(Cotacao cotacao) {
        return new CotacaoEntity(cotacao.getId(), cotacao.getValorPago(), cotacao.getStatus(), cotacao.getDataPagamento(), ClienteEntityMapper.toEntity(cotacao.getCliente()), DestinoEntityMapper.toEntity(cotacao.getDestino()));
    }
}
