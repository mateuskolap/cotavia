package br.com.pooj.cotavia.app.usecases.destination;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.pooj.cotavia.core.interfaces.destination.FindDestinationByIdCase;
import br.com.pooj.cotavia.core.models.Destination;
import br.com.pooj.cotavia.core.repositories.DestinationRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FindDestinationByIdCaseImpl implements FindDestinationByIdCase {
    private final DestinationRepository destinationRepository;

    @Override
    public Optional<Destination> execute(Long id) {
        return destinationRepository.findById(id);
    }
}
