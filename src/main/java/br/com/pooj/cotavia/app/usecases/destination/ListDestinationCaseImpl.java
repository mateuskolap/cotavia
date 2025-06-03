package br.com.pooj.cotavia.app.usecases.destination;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.pooj.cotavia.core.interfaces.destination.ListDestinationCase;
import br.com.pooj.cotavia.core.models.Destination;
import br.com.pooj.cotavia.core.repositories.DestinationRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ListDestinationCaseImpl implements ListDestinationCase {
    private final DestinationRepository destinationRepository;

    @Override
    public List<Destination> execute() {
        return destinationRepository.findAll();
    }
}
