package br.com.pooj.cotavia.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_pagamento")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class PagamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal valorPago;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String dataPagamento;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cotacao_id", nullable = false)
    private CotacaoEntity cotacao;
}
