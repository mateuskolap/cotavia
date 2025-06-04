package br.com.pooj.cotavia.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pooj.cotavia.api.dtos.request.CreatePaymentRequestDto;
import br.com.pooj.cotavia.api.dtos.request.UpdatePaymentStatusRequestDto;
import br.com.pooj.cotavia.api.dtos.response.PaymentResponseDto;
import br.com.pooj.cotavia.app.usecases.payment.FindPaymentByIdCaseImpl;
import br.com.pooj.cotavia.app.usecases.payment.RegisterPaymentCaseImpl;
import br.com.pooj.cotavia.app.usecases.payment.RemovePaymentCaseImpl;
import br.com.pooj.cotavia.app.usecases.payment.UpdatePaymentStatusCaseImpl;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/pagamentos")
@AllArgsConstructor
public class PaymentController {
    private final RegisterPaymentCaseImpl registerPaymentCaseImpl;
    private final FindPaymentByIdCaseImpl findPaymentByIdCaseImpl;
    private final UpdatePaymentStatusCaseImpl updatePaymentStatusCaseImpl;
    private final RemovePaymentCaseImpl removePaymentCaseImpl;

    @Operation(summary = "Registrar pagamento", description = "Registra um novo pagamento para uma cotação")
    @PostMapping
    public ResponseEntity<PaymentResponseDto> register(@RequestBody @Valid CreatePaymentRequestDto request) {
        PaymentResponseDto response = registerPaymentCaseImpl.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Buscar pagamento pelo id", description = "Retorna os dados de um pagamento com base no id informado")
    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponseDto> findById(@PathVariable Long id) {
        PaymentResponseDto response = findPaymentByIdCaseImpl.execute(id)
            .orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Atualizar status do pagamento", description = "Atualiza o status de um pagamento existente")
    @PostMapping("/{id}/status")
    public ResponseEntity<Void> updateStatus(@PathVariable Long id, @RequestBody @Valid UpdatePaymentStatusRequestDto request) {
        updatePaymentStatusCaseImpl.execute(id, request.getStatus());
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Remover pagamento", description = "Remove um pagamento com base no id informado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        removePaymentCaseImpl.execute(id);
        return ResponseEntity.noContent().build();
    }
}
