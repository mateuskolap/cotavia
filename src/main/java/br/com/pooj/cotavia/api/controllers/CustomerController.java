package br.com.pooj.cotavia.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pooj.cotavia.api.dtos.request.CreateCustomerRequestDto;
import br.com.pooj.cotavia.api.dtos.response.CustomerResponseDTO;
import br.com.pooj.cotavia.api.mappers.CustomerDtoMapper;
import br.com.pooj.cotavia.core.interfaces.customer.CreateCustomerCase;
import br.com.pooj.cotavia.core.interfaces.customer.FindCustomerByEmailCase;
import br.com.pooj.cotavia.core.interfaces.customer.ListCustomerCase;
import br.com.pooj.cotavia.core.interfaces.customer.UpdateCustomerCase;
import br.com.pooj.cotavia.core.models.Customer;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

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

    private final CustomerDtoMapper customerDtoMapper;
    
    @Operation(summary = "Cadastrar cliente", description = "Cadastra um novo cliente no sistema")
    @PostMapping
    public ResponseEntity<CustomerResponseDTO> create(@RequestBody @Valid CreateCustomerRequestDto request) {
        Customer customer = customerDtoMapper.toDomain(request);
        Customer created = createCustomerCase.execute(customer);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(customerDtoMapper.toResponse(created));
    }
    
    @Operation(summary = "Buscar cliente por e-mail", description = "Retorna os dados de um cliente com base no e-mail informado")
    @GetMapping("/email/{email}")
    public ResponseEntity<CustomerResponseDTO> findByEmail(@PathVariable String email) {
        Customer customer = findCustomerByEmailCase.execute(email)
            .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        return ResponseEntity.ok(customerDtoMapper.toResponse(customer));
    }

    @Operation(summary = "Listar clientes", description = "Retorna uma lista com todos os clientes cadastrados")
    @GetMapping
    public ResponseEntity<List<CustomerResponseDTO>> listAll() {
        List<Customer> customers = listCustomerCase.execute();
        List<CustomerResponseDTO> responseList = customers.stream()
            .map(customerDtoMapper::toResponse)
            .collect(Collectors.toList());

        return ResponseEntity.ok(responseList);
    }

    @Operation(summary = "Atualizar cliente", description = "Atualiza completamente os dados de um cliente existente")
    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> update(@PathVariable Long id, @RequestBody @Valid CreateCustomerRequestDto request) {
        Customer updated = updateCustomerCase.execute(id, customerDtoMapper.toDomain(request));

        return ResponseEntity.ok(customerDtoMapper.toResponse(updated));
    }
}
