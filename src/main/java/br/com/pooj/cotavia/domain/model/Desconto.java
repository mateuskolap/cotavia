package br.com.pooj.cotavia.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Desconto {
    private Long id;
    private BigDecimal valorDesconto;
    private String descricao;
    private LocalDateTime dataAplicacao;
    private Cotacao cotacao;
}
