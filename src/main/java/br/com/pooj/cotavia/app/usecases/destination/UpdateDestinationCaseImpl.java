package br.com.pooj.cotavia.app.usecases.destination;

import org.springframework.stereotype.Service;

import br.com.pooj.cotavia.core.interfaces.destination.UpdateDestinationCase;
import br.com.pooj.cotavia.core.models.Destination;
import br.com.pooj.cotavia.core.repositories.DestinationRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UpdateDestinationCaseImpl implements UpdateDestinationCase {
    private final DestinationRepository destinationRepository;

    @Override
    public Destination execute(Long id, Destination updatedDestination) {
        Destination existing = destinationRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Destino não encontrado"));

        existing.setName(updatedDestination.getName());
        existing.setDescription(updatedDestination.getDescription());
        existing.setAddress(updatedDestination.getAddress());
        existing.setPricePerPerson(updatedDestination.getPricePerPerson());

        return destinationRepository.save(existing);
    }
}
