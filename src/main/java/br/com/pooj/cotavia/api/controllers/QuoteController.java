package br.com.pooj.cotavia.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pooj.cotavia.api.dtos.request.CreateQuoteRequestDto;
import br.com.pooj.cotavia.api.dtos.request.UpdateQuoteStatusRequestDto;
import br.com.pooj.cotavia.api.dtos.response.QuoteResponseDto;
import br.com.pooj.cotavia.app.usecases.quote.UpdateQuoteStatusCaseImpl;
import br.com.pooj.cotavia.core.interfaces.quote.CreateQuoteCase;
import br.com.pooj.cotavia.core.interfaces.quote.DeleteQuoteByIdCase;
import br.com.pooj.cotavia.core.interfaces.quote.FindQuoteByIdCase;
import br.com.pooj.cotavia.core.interfaces.quote.ListQuoteCase;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/cotacoes")
@AllArgsConstructor
public class QuoteController {
    private final CreateQuoteCase createQuoteCase;
    private final ListQuoteCase listQuoteCase;
    private final FindQuoteByIdCase findQuoteByIdCase;
    private final UpdateQuoteStatusCaseImpl updateQuoteStatusCaseImpl;
    private final DeleteQuoteByIdCase deleteQuoteByIdCase;

    @Operation(summary = "Criar cotacao", description = "Cria uma nova cotacao no sistema")
    @PostMapping
    public ResponseEntity<QuoteResponseDto> create(@RequestBody @Valid CreateQuoteRequestDto request) {
        QuoteResponseDto created = createQuoteCase.execute(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @Operation(summary = "Listar cotacoes", description = "Retorna uma lista com todas as cotacoes cadastradas")
    @GetMapping
    public ResponseEntity<List<QuoteResponseDto>> listAll() {
        List<QuoteResponseDto> responseList = listQuoteCase.execute();

        return ResponseEntity.ok(responseList);
    }

    @Operation(summary = "Buscar cotacao pelo id", description = "Retorna as informacoes da cotacao com base no id informado")
    @GetMapping("/{id}")
    public ResponseEntity<QuoteResponseDto> findById(@PathVariable Long id) {
        QuoteResponseDto response = findQuoteByIdCase.execute(id)
            .orElseThrow(() -> new RuntimeException("Cotação não encontrada"));

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Atualizar status da cotação", description = "Atualiza o status de uma cotação existente")
    @PostMapping("/{id}/status")
    public ResponseEntity<Void> updateStatus(@PathVariable Long id, @RequestBody @Valid UpdateQuoteStatusRequestDto request) {
        updateQuoteStatusCaseImpl.execute(id, request.getStatus());

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Remover cotação", description = "Remove uma cotacao existente com base no id informado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deleteQuoteByIdCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
