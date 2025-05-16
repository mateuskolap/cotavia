package br.com.pooj.cotavia.presentation.controller;

import br.com.pooj.cotavia.application.usecases.destino.*;
import br.com.pooj.cotavia.domain.model.Destino;
import br.com.pooj.cotavia.presentation.dto.destino.AtualizarDestinoRequest;
import br.com.pooj.cotavia.presentation.dto.destino.CadastrarDestinoRequest;
import br.com.pooj.cotavia.presentation.dto.destino.DestinoResponse;
import br.com.pooj.cotavia.presentation.dto.destino.mapper.DestinoRequestMapper;
import br.com.pooj.cotavia.presentation.dto.destino.mapper.DestinoResponseMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import jakarta.validation.Valid;
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

@Tag(name = "Destinos", description = "Endpoint para gerenciamento de destinos.")
@RestController
@RequestMapping("/api/destino")
public class DestinoController {
    private final AtualizarDestinoService atualizarDestinoService;
    private final CadastrarDestinoService cadastrarDestinoService;
    private final ConsultarDestinoPorIdService consultarDestinoPorIdService;
    private final DeletarDestinoService deletarDestinoService;
    private final ListarDestinosService listarDestinosService;

    public DestinoController(AtualizarDestinoService atualizarDestinoService, CadastrarDestinoService cadastrarDestinoService, ConsultarDestinoPorIdService consultarDestinoPorIdService, DeletarDestinoService deletarDestinoService, ListarDestinosService listarDestinosService) {
        this.atualizarDestinoService = atualizarDestinoService;
        this.cadastrarDestinoService = cadastrarDestinoService;
        this.consultarDestinoPorIdService = consultarDestinoPorIdService;
        this.deletarDestinoService = deletarDestinoService;
        this.listarDestinosService = listarDestinosService;
    }

    @Operation(summary = "Cadastra um novo destino", description = "Cadastra um novo destino no sistema")
    @PostMapping
    public ResponseEntity<DestinoResponse> criar(@RequestBody @Valid CadastrarDestinoRequest request) {
        Destino destinoDomain = DestinoRequestMapper.toDomain(request);
        Destino destinoSalvo = cadastrarDestinoService.cadastrar(destinoDomain);
        DestinoResponse destinoResponse = DestinoResponseMapper.toResponse(destinoSalvo);

        return ResponseEntity.status(HttpStatus.CREATED).body(destinoResponse);
    }

    @Operation(summary = "Atualizar um destino", description = "Atualiza o cadastro do destino")
    @PutMapping("/{id}")
    public ResponseEntity<DestinoResponse> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarDestinoRequest request) {
        Destino destinoParaAtualizar = DestinoRequestMapper.toDomain(request);

        return atualizarDestinoService.atualizar(id, destinoParaAtualizar)
                .map(DestinoResponseMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Lista todos os destinos", description = "Retorna uma lista com todos os destinos cadastrados")
    @GetMapping
    public ResponseEntity<List<DestinoResponse>> listarTodos() {
        List<Destino> destinos = listarDestinosService.listarTodos();

        List<DestinoResponse> responseList = destinos.stream().
                map(DestinoResponseMapper::toResponse)
                .toList();

        return ResponseEntity.ok(responseList);
    }

    @Operation(summary = "Busca um destino pelo seu ID", description = "Retorna um objeto Destino pelo ID")
    @GetMapping("/{id}")
    public ResponseEntity<DestinoResponse> buscarPorId(@PathVariable Long id) {
        return consultarDestinoPorIdService.consultarPorId(id)
                .map(DestinoResponseMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Deleta o destino", description = "Remove o destino do sistema pelo ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return deletarDestinoService.deletar(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
