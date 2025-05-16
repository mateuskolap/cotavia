package br.com.pooj.cotavia.presentation.dto.destino;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class CadastrarDestinoRequest {
    @NotBlank(message = "O nome é obrigatório")
    private String nome;
    
    private String descricao;

    @NotBlank(message = "A localização é obrigatória")
    private String localizacao;

    @NotBlank(message = "O valor por pessoa é obrigatório")
    private BigDecimal precoPorPessoa;
}
