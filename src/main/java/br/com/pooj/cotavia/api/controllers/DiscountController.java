package br.com.pooj.cotavia.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pooj.cotavia.api.dtos.request.CreateDiscountRequestDto;
import br.com.pooj.cotavia.api.dtos.response.DiscountResponseDto;
import br.com.pooj.cotavia.core.interfaces.discount.FindDiscountByIdCase;
import br.com.pooj.cotavia.core.interfaces.discount.ListDiscountByQuoteCase;
import br.com.pooj.cotavia.core.interfaces.discount.ListDiscountCase;
import br.com.pooj.cotavia.core.interfaces.discount.RegisterDiscountCase;
import br.com.pooj.cotavia.core.interfaces.discount.RemoveDiscountCase;
import br.com.pooj.cotavia.core.interfaces.discount.UpdateDiscountCase;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/descontos")
@AllArgsConstructor
public class DiscountController {
    private final RegisterDiscountCase registerDiscountCase;
    private final ListDiscountCase listDiscountCase;
    private final ListDiscountByQuoteCase listDiscountByQuoteCase;
    private final FindDiscountByIdCase findDiscountByIdCase;
    private final UpdateDiscountCase updateDiscountCase;
    private final RemoveDiscountCase removeDiscountCase;

    @Operation(summary = "Registrar desconto", description = "Registra um novo desconto no sistema")
    @PostMapping
    public ResponseEntity<DiscountResponseDto> create(@RequestBody @Valid CreateDiscountRequestDto request) {
        DiscountResponseDto discount = registerDiscountCase.execute(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(discount);
    }

    @Operation(summary = "Listar descontos", description = "Retorna uma lista com todos os descontos cadastrados")
    @GetMapping
    public ResponseEntity<List<DiscountResponseDto>> listAll() {
        List<DiscountResponseDto> responseList = listDiscountCase.execute();

        return ResponseEntity.ok(responseList);
    }

    @Operation(summary = "Listar descontos de uma cotação", description = "Retorna uma lista com todos os descontos de uma cotação específica")
    @GetMapping("/cotacoes/{id}")
    public ResponseEntity<List<DiscountResponseDto>> listAllByQuoteId(@PathVariable Long id) {
        List<DiscountResponseDto> responseList = listDiscountByQuoteCase.execute(id);

        return ResponseEntity.ok(responseList);
    }

    @Operation(summary = "Buscar desconto pelo id", description = "Retorna os dados de um desconto com base no id informado")
    @GetMapping("/{id}")
    public ResponseEntity<DiscountResponseDto> findById(@PathVariable Long id) {
        DiscountResponseDto response = findDiscountByIdCase.execute(id)
            .orElseThrow(() -> new RuntimeException("Desconto não encontrado"));

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Atualizar desconto", description = "Atualiza completamente os dados de um desconto existente")
    @PutMapping("/{id}")
    public ResponseEntity<DiscountResponseDto> update(@PathVariable Long id, @RequestBody @Valid CreateDiscountRequestDto request) {
        DiscountResponseDto updated = updateDiscountCase.execute(id, request);
        return ResponseEntity.ok(updated);
    }

    @Operation(summary = "Remover desconto", description = "Remover um desconto existente com base no id informado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        removeDiscountCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
