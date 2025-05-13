package br.com.pooj.cotavia.interfaces.controller;

import br.com.pooj.cotavia.application.services.cliente.AtualizarClienteService;
import br.com.pooj.cotavia.application.services.cliente.BuscarClientePorEmailService;
import br.com.pooj.cotavia.application.services.cliente.CriarClienteService;
import br.com.pooj.cotavia.application.services.cliente.ListarClientesService;
import br.com.pooj.cotavia.domain.model.Cliente;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Clientes", description = "Endpoint para reconcilement de clientes.")
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private final CriarClienteService criarClienteService;
    private final ListarClientesService listarClientesService;
    private final BuscarClientePorEmailService buscarClientePorEmailService;
    private final AtualizarClienteService atualizarClienteService;

    public ClienteController(CriarClienteService criarClienteService, ListarClientesService listarClientesService, BuscarClientePorEmailService buscarClientePorEmailService, AtualizarClienteService atualizarClienteService) {
        this.criarClienteService = criarClienteService;
        this.listarClientesService = listarClientesService;
        this.buscarClientePorEmailService = buscarClientePorEmailService;
        this.atualizarClienteService = atualizarClienteService;
    }

    @Operation(summary = "Cria um novo cliente", description = "Cadastra um novo cliente no sistema")
    @PostMapping
    public ResponseEntity<Cliente> criar(@RequestBody Cliente cliente) {
        Cliente novo = criarClienteService.criar(cliente);
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
        return buscarClientePorEmailService.buscarPorEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        return atualizarClienteService.atualizar(id, cliente)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
