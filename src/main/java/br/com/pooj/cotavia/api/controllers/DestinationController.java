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

import br.com.pooj.cotavia.api.dtos.request.CreateDestinationRequestDto;
import br.com.pooj.cotavia.api.dtos.response.DestinationResponseDto;
import br.com.pooj.cotavia.core.interfaces.destination.DeleteDestinationCase;
import br.com.pooj.cotavia.core.interfaces.destination.FindDestinationByIdCase;
import br.com.pooj.cotavia.core.interfaces.destination.ListDestinationCase;
import br.com.pooj.cotavia.core.interfaces.destination.RegisterDestinationCase;
import br.com.pooj.cotavia.core.interfaces.destination.UpdateDestinationCase;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/destinos")
@AllArgsConstructor
public class DestinationController {
    private final RegisterDestinationCase registerDestinationCase;
    private final ListDestinationCase listDestinationCase;
    private final FindDestinationByIdCase findDestinationByIdCase;
    private final UpdateDestinationCase updateDestinationCase;
    private final DeleteDestinationCase deleteDestinationCase;

    @Operation(summary = "Registrar destino", description = "Registra um novo destino no sistema")
    @PostMapping
    public ResponseEntity<DestinationResponseDto> create(@RequestBody @Valid CreateDestinationRequestDto request) {
        DestinationResponseDto destination = registerDestinationCase.execute(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(destination);
    }

    @Operation(summary = "Listar destinos", description = "Retorna uma lista com todos os destinos cadastrados")
    @GetMapping
    public ResponseEntity<List<DestinationResponseDto>> listAll() {
        List<DestinationResponseDto> responseList = listDestinationCase.execute();

        return ResponseEntity.ok(responseList);
    }

    @Operation(summary = "Buscar destino pelo id", description = "Retorna os dados de um cliente com base no id informado")
    @GetMapping("/{id}")
    public ResponseEntity<DestinationResponseDto> findById(@PathVariable Long id) {
        DestinationResponseDto response = findDestinationByIdCase.execute(id)
            .orElseThrow(() -> new RuntimeException("Destino não encontrado"));

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Atualizar destino", description = "Atualiza completamente os dados de um destino existente")
    @PutMapping("/{id}")
    public ResponseEntity<DestinationResponseDto> update(@PathVariable Long id, @RequestBody @Valid CreateDestinationRequestDto request) {
        DestinationResponseDto updated = updateDestinationCase.execute(id, request);
        return ResponseEntity.ok(updated);
    }

    @Operation(summary = "Excluir destino", description = "Exclui um destino existente com base no id informado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deleteDestinationCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
