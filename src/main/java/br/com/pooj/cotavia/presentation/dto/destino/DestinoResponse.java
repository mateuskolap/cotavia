package br.com.pooj.cotavia.presentation.dto.destino;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class DestinoResponse {
    private Long id;
    private String nome;
    private String descricao;
    private String localizacao;
    private BigDecimal precoPorPessoa;
}
