package br.com.pooj.cotavia.api.controllers;

import java.util.List;
import java.util.stream.Collectors;

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
import br.com.pooj.cotavia.api.dtos.response.DestinationResponseDTO;
import br.com.pooj.cotavia.api.mappers.DestinationDtoMapper;
import br.com.pooj.cotavia.core.interfaces.destination.DeleteDestinationCase;
import br.com.pooj.cotavia.core.interfaces.destination.FindDestinationByIdCase;
import br.com.pooj.cotavia.core.interfaces.destination.ListDestinationCase;
import br.com.pooj.cotavia.core.interfaces.destination.RegisterDestinationCase;
import br.com.pooj.cotavia.core.interfaces.destination.UpdateDestinationCase;
import br.com.pooj.cotavia.core.models.Destination;
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

    private final DestinationDtoMapper destinationDtoMapper;

    @Operation(summary = "Registrar destino", description = "Registra um novo destino no sistema")
    @PostMapping
    public ResponseEntity<DestinationResponseDTO> create(@RequestBody @Valid CreateDestinationRequestDto request) {
        Destination destination = destinationDtoMapper.toDomain(request);
        Destination created = registerDestinationCase.execute(destination);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(destinationDtoMapper.toResponse(created));
    }

    @Operation(summary = "Listar destinos", description = "Retorna uma lista com todos os destinos cadastrados")
    @GetMapping
    public ResponseEntity<List<DestinationResponseDTO>> listAll() {
        List<Destination> destinations = listDestinationCase.execute();
        List<DestinationResponseDTO> responseList = destinations.stream()
            .map(destinationDtoMapper::toResponse)
            .collect(Collectors.toList());

        return ResponseEntity.ok(responseList);
    }

    @Operation(summary = "Buscar cliente por id", description = "Retorna os dados de um cliente com base no id informado")
    @GetMapping("/destinos/{id}")
    public ResponseEntity<DestinationResponseDTO> findById(@PathVariable Long id) {
        Destination destination = findDestinationByIdCase.execute(id)
            .orElseThrow(() -> new RuntimeException("Destino não encontrado"));

        return ResponseEntity.ok(destinationDtoMapper.toResponse(destination));
    }

    @Operation(summary = "Atualizar destino", description = "Atualiza completamente os dados de um destino existente")
    @PutMapping("/{id}")
    public ResponseEntity<DestinationResponseDTO> update(@PathVariable Long id, @RequestBody @Valid CreateDestinationRequestDto request) {
        Destination updated = updateDestinationCase.execute(id, destinationDtoMapper.toDomain(request));

        return ResponseEntity.ok(destinationDtoMapper.toResponse(updated));
    }

    @Operation(summary = "Excluir destino", description = "Exclui um destino existente com base no id informado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deleteDestinationCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
