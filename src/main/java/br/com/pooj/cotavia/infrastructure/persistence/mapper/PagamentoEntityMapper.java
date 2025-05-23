package br.com.pooj.cotavia.infrastructure.persistence.mapper;

import br.com.pooj.cotavia.domain.model.Pagamento;
import br.com.pooj.cotavia.infrastructure.persistence.entity.PagamentoEntity;

public class PagamentoEntityMapper {
    public static Pagamento toDomain(PagamentoEntity entity) {
        return new Pagamento(entity.getId(), entity.getValorPago(), entity.getStatus(), entity.getDataPagamento(), CotacaoEntityMapper.toDomain(entity.getCotacao()));
    }

    public static PagamentoEntity toEntity(Pagamento pagamento) {
        return new PagamentoEntity(pagamento.getId(), pagamento.getValorPago(), pagamento.getStatus(), pagamento.getDataPagamento(), CotacaoEntityMapper.toEntity(pagamento.getCotacao()));
    }
}
