package br.com.pooj.cotavia.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pooj.cotavia.api.dtos.request.CreateDestinationRequest;
import br.com.pooj.cotavia.api.dtos.response.DestinationResponse;
import br.com.pooj.cotavia.api.mappers.DestinationDtoMapper;
// import br.com.pooj.cotavia.core.interfaces.destination.DeleteDestinationCase;
// import br.com.pooj.cotavia.core.interfaces.destination.FindDestinationByIdCase;
// import br.com.pooj.cotavia.core.interfaces.destination.ListDestinationCase;
import br.com.pooj.cotavia.core.interfaces.destination.RegisterDestinationCase;
// import br.com.pooj.cotavia.core.interfaces.destination.UpdateDestinationCase;
import br.com.pooj.cotavia.core.models.Destination;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/destinos")
@AllArgsConstructor
public class DestinationController {
    private final RegisterDestinationCase registerDestinationCase;
    // private final ListDestinationCase listDestinationCase;
    // private final FindDestinationByIdCase findDestinationByIdCase;
    // private final UpdateDestinationCase updateDestinationCase;
    // private final DeleteDestinationCase deleteDestinationCase;

    private final DestinationDtoMapper destinationDtoMapper;

    @PostMapping
    public ResponseEntity<DestinationResponse> create(@RequestBody @Valid CreateDestinationRequest request) {
        Destination destination = destinationDtoMapper.toDomain(request);
        Destination created = registerDestinationCase.execute(destination);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(destinationDtoMapper.toResponse(created));
    }
}
