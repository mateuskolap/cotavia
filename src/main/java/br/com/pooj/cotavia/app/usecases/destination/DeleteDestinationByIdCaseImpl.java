package br.com.pooj.cotavia.app.usecases.destination;

import org.springframework.stereotype.Service;

import br.com.pooj.cotavia.core.interfaces.destination.DeleteDestinationCase;
import br.com.pooj.cotavia.core.repositories.DestinationRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DeleteDestinationByIdCaseImpl implements DeleteDestinationCase {
    private final DestinationRepository destinationRepository;

    @Override
    public void execute(Long id) {
        if (!destinationRepository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado");
        }

        destinationRepository.deleteById(id);
    }
}
