package br.com.pooj.cotavia.infrastructure.persistence.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.pooj.cotavia.domain.enums.StatusCotacao;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tb_cotacao")
@AllArgsConstructor @NoArgsConstructor
public class CotacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal valorPago;
    
    @Enumerated(StatusCotacao)
    @Column(nullable = false)
    private StatusCotacao status;
    
    @Column(nullable = false)
    private LocalDateTime dataPagamento;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClienteEntity cliente;
}
