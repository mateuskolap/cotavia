package br.com.pooj.cotavia.presentation.controller;

import br.com.pooj.cotavia.application.usecases.cliente.AtualizarClienteService;
import br.com.pooj.cotavia.application.usecases.cliente.ConsultarClientePorEmailService;
import br.com.pooj.cotavia.application.usecases.cliente.CadastrarClienteService;
import br.com.pooj.cotavia.application.usecases.cliente.ListarClientesService;
import br.com.pooj.cotavia.domain.model.Cliente;
import br.com.pooj.cotavia.presentation.dto.cliente.AtualizarClienteRequest;
import br.com.pooj.cotavia.presentation.dto.cliente.CadastrarClienteRequest;
import br.com.pooj.cotavia.presentation.dto.cliente.ClienteResponse;
import br.com.pooj.cotavia.presentation.dto.cliente.mapper.ClienteRequestMapper;
import br.com.pooj.cotavia.presentation.dto.cliente.mapper.ClienteResponseMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
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

    @Operation(summary = "Cadastra um novo cliente", description = "Cadastra um novo cliente no sistema")
    @PostMapping
    public ResponseEntity<ClienteResponse> cadastrar(@RequestBody @Valid CadastrarClienteRequest request) {
        Cliente clienteDomain = ClienteRequestMapper.toDomain(request);
        Cliente clienteSalvo = cadastrarClienteService.cadastrar(clienteDomain);
        ClienteResponse clienteResponse = ClienteResponseMapper.toResponse(clienteSalvo);

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteResponse);
    }

    @Operation(summary = "Lista todos os clientes", description = "Retorna uma lista com todos os usuários cadastrados")
    @GetMapping
    public ResponseEntity<List<ClienteResponse>> listarTodos() {
        List<Cliente> clientes = listarClientesService.listarTodos();

        List<ClienteResponse> responseList = clientes.stream()
                .map(ClienteResponseMapper::toResponse)
                .toList();

        return ResponseEntity.ok(responseList);
    }

    @Operation(summary = "Busca um cliente pelo seu email", description = "Retorna um objeto Cliente o e-mail")
    @GetMapping("/{email}")
    public ResponseEntity<ClienteResponse> buscarPorEmail(@PathVariable String email) {
        return consultarClientePorEmailService.consultarPorEmail(email)
                .map(ClienteResponseMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Atualiza um cliente", description = "Atualiza o cadastro de um cliente")
    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarClienteRequest cliente) {
        Cliente clienteParaAtualizar = ClienteRequestMapper.toDomain(cliente);

        return atualizarClienteService.atualizar(id, clienteParaAtualizar)
                .map(ClienteResponseMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
