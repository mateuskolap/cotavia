package br.com.pooj.cotavia.application.usecases.destino;

import br.com.pooj.cotavia.infrastructure.persistence.repository.DestinoJpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DeletarDestinoService {
    private final DestinoJpaRepository destinoRepository;

    public DeletarDestinoService(DestinoJpaRepository destinoRepository) { this.destinoRepository = destinoRepository; }

    public boolean deletar(Long id) {
        if (!destinoRepository.existsById(id)) {
            return false;
        }

        destinoRepository.deleteById(id);
        return true;
    }
}
