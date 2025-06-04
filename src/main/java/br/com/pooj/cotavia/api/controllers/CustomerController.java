package br.com.pooj.cotavia.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pooj.cotavia.api.dtos.request.CreateCustomerRequestDto;
import br.com.pooj.cotavia.api.dtos.response.CustomerResponseDto;
import br.com.pooj.cotavia.core.interfaces.customer.CreateCustomerCase;
import br.com.pooj.cotavia.core.interfaces.customer.FindCustomerByEmailCase;
import br.com.pooj.cotavia.core.interfaces.customer.ListCustomerCase;
import br.com.pooj.cotavia.core.interfaces.customer.UpdateCustomerCase;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class CustomerController {
    private final CreateCustomerCase createCustomerCase;
    private final FindCustomerByEmailCase findCustomerByEmailCase;
    private final ListCustomerCase listCustomerCase;
    private final UpdateCustomerCase updateCustomerCase;

    @Operation(summary = "Cadastrar cliente", description = "Cadastra um novo cliente no sistema")
    @PostMapping
    public ResponseEntity<CustomerResponseDto> create(@RequestBody @Valid CreateCustomerRequestDto request) {
        CustomerResponseDto response = createCustomerCase.execute(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Buscar cliente por e-mail", description = "Retorna os dados de um cliente com base no e-mail informado")
    @GetMapping("/email/{email}")
    public ResponseEntity<CustomerResponseDto> findByEmail(@PathVariable String email) {
        CustomerResponseDto response = findCustomerByEmailCase.execute(email)
            .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Listar clientes", description = "Retorna uma lista com todos os clientes cadastrados")
    @GetMapping
    public ResponseEntity<List<CustomerResponseDto>> listAll() {
        List<CustomerResponseDto> responseList = listCustomerCase.execute();

        return ResponseEntity.ok(responseList);
    }

    @Operation(summary = "Atualizar cliente", description = "Atualiza completamente os dados de um cliente existente")
    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponseDto> update(@PathVariable Long id, @RequestBody @Valid CreateCustomerRequestDto request) {
        CustomerResponseDto updated = updateCustomerCase.execute(id, request);

        return ResponseEntity.ok(updated);
    }
}
