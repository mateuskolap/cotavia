package br.com.pooj.cotavia.app.usecases.destination;

import org.springframework.stereotype.Service;

import br.com.pooj.cotavia.core.interfaces.destination.RegisterDestinationCase;
import br.com.pooj.cotavia.core.models.Destination;
import br.com.pooj.cotavia.core.repositories.DestinationRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegisterDestinationCaseImpl implements RegisterDestinationCase {
    private final DestinationRepository destinationRepository;

    @Override
    public Destination execute(Destination destination) {
        return destinationRepository.save(destination);
    }
}
