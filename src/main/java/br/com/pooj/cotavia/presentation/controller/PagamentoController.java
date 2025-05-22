package br.com.pooj.cotavia.presentation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pooj.cotavia.application.usecases.pagamento.AtualizarStatusPagamentoService;
import br.com.pooj.cotavia.application.usecases.pagamento.DeletarPagamentoService;
import br.com.pooj.cotavia.application.usecases.pagamento.ObterPagamentoService;
import br.com.pooj.cotavia.application.usecases.pagamento.RegistrarPagamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Pagamentos", description = "Endpoint para gerenciamento de pagamentos.")
@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {
    private final RegistrarPagamentoService registrarPagamentoService;
    private final ObterPagamentoService obterPagamentoService;
    private final AtualizarStatusPagamentoService atualizarStatusPagamentoService;
    private final DeletarPagamentoService deletarPagamentoService;

    public PagamentoController(RegistrarPagamentoService registrarPagamentoService, ObterPagamentoService obterPagamentoService, AtualizarStatusPagamentoService atualizarStatusPagamentoService, DeletarPagamentoService deletarPagamentoService) {
        this.registrarPagamentoService = registrarPagamentoService;
        this.obterPagamentoService = obterPagamentoService;
        this.atualizarStatusPagamentoService = atualizarStatusPagamentoService;
        this.deletarPagamentoService = deletarPagamentoService;
    }

    @Operation(summary = "Registrar um novo pagamento", description = "Registra um novo pagamento no sistema")
    @PostMapping
    public ResponseEntity<PagamentoResponse> registrar(@RequestBody @Valid RegistrarPagamentoRequest request) {
        Pagamento pagamentoDomain = PagamentoRequestMapper.toDomain(request);
        Pagamento pagamentoSalvo = registrarPagamentoService.registrar(pagamentoDomain);
        PagamentoResponse pagamentoResponse = PagamentoResponseMapper.toResponse(pagamentoSalvo);

        return ResponseEntity.status(HttpStatus.CREATED).body(pagamentoResponse);
    }

    @Operation(summary = "Obter um pagamento por ID", description = "Retorna um pagamento pelo seu ID")
    @GetMapping("/{id}")
    public ResponseEntity<PagamentoResponse> obter(@PathVariable Long id) {
        Pagamento pagamento = obterPagamentoService.obterPorId(id);
        PagamentoResponse pagamentoResponse = PagamentoResponseMapper.toResponse(pagamento);

        return ResponseEntity.ok(pagamentoResponse);
    }

    @Operation(summary = "Atualizar um pagamento", description = "Atualiza os dados de um pagamento")
    @PutMapping("/{id}")
    public ResponseEntity<PagamentoResponse> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarStatusPagamentoRequest request) {
        Pagamento pagamentoAtualizado = PagamentoRequestMapper.toDomain(request);

        return atualizarStatusPagamentoService.atualizar(id, pagamentoAtualizado)
                .map(PagamentoResponseMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Deletar um pagamento", description = "Remove um pagamento do sistema")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return deletarPagamentoService.deletar(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
