package br.com.pooj.cotavia.presentation.controller;

import br.com.pooj.cotavia.application.usecases.cliente.AtualizarClienteService;
import br.com.pooj.cotavia.application.usecases.cliente.ConsultarClientePorEmailService;
import br.com.pooj.cotavia.application.usecases.cliente.CadastrarClienteService;
import br.com.pooj.cotavia.application.usecases.cliente.ListarClientesService;
import br.com.pooj.cotavia.domain.model.Cliente;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Clientes", description = "Endpoint para gerenciamento de clientes.")
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private final CadastrarClienteService cadastrarClienteService;
    private final ListarClientesService listarClientesService;
    private final ConsultarClientePorEmailService consultarClientePorEmailService;
    private final AtualizarClienteService atualizarClienteService;

    public ClienteController(CadastrarClienteService cadastrarClienteService, ListarClientesService listarClientesService, ConsultarClientePorEmailService consultarClientePorEmailService, AtualizarClienteService atualizarClienteService) {
        this.cadastrarClienteService = cadastrarClienteService;
        this.listarClientesService = listarClientesService;
        this.consultarClientePorEmailService = consultarClientePorEmailService;
        this.atualizarClienteService = atualizarClienteService;
    }

    @Operation(summary = "Cria um novo cliente", description = "Cadastra um novo cliente no sistema")
    @PostMapping
    public ResponseEntity<Cliente> criar(@RequestBody Cliente cliente) {
        Cliente novo = cadastrarClienteService.criar(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    @Operation(summary = "Lista todos os clientes", description = "Retorna uma lista com todos os usuários cadastrados")
    @GetMapping
    public ResponseEntity<List<Cliente>> listarTodos() {
        return ResponseEntity.ok(listarClientesService.listarTodos());
    }

    @Operation(summary = "Busca um cliente pelo seu email", description = "Retorna um objeto Cliente o e-mail")
    @GetMapping("/{email}")
    public ResponseEntity<Cliente> buscarPorEmail(@PathVariable String email) {
        return consultarClientePorEmailService.consultarPorEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "atualiza o cliente", description = "atualiza o cadastro do cliente")
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        return atualizarClienteService.atualizar(id, cliente)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
