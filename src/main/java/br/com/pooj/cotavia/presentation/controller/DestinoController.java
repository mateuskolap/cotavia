package br.com.pooj.cotavia.presentation.controller;

import br.com.pooj.cotavia.application.usecases.destino.*;
import br.com.pooj.cotavia.domain.model.Destino;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

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

@Tag(name = "Destinos", description = "Endpoint para gerenciamento de clientes.")
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

    @Operation(summary = "Cria um novo destino", description = "Cadastra um novo destino no sistema")
    @PostMapping
    public ResponseEntity<Destino> criar(@RequestBody Destino destino) {
        Destino novo = cadastrarDestinoService.cadastrar(destino);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    @Operation(summary = "atualiza o destino", description = "atualiza o cadastro do destino")
    @PutMapping("/{id}")
    public ResponseEntity<Destino> atualizar(@PathVariable Long id, @RequestBody Destino destino) {
        return atualizarDestinoService.atualizar(id, destino)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Lista todos os destinos", description = "Retorna uma lista com todos os destinos cadastrados")
    @GetMapping
    public ResponseEntity<List<Destino>> listarTodos() {
        return ResponseEntity.ok(listarDestinosService.listarTodos());
    }

    @Operation(summary = "Busca um destino pelo seu ID", description = "Retorna um objeto Destino pelo ID")
    @GetMapping("/{id}")
    public ResponseEntity<Destino> buscarPorId(@PathVariable Long id) {
        return consultarDestinoPorIdService.consultarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Deleta o destino", description = "Remove o destino do sistema pelo ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean deletado = deletarDestinoService.deletar(id);
        if (deletado) {
            return ResponseEntity.noContent().build(); 
        } else {
            return ResponseEntity.notFound().build();  
        }
    }
}
