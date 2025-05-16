package br.com.pooj.cotavia.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Destino {
    private Long id;
    private String nome;
    private String descricao;
    private String localizacao;
    private BigDecimal precoPorPessoa;
}
