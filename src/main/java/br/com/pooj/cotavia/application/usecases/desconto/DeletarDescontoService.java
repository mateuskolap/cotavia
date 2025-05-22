package br.com.pooj.cotavia.application.usecases.desconto;

import br.com.pooj.cotavia.infrastructure.persistence.repository.DescontoJpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DeletarDescontoService {
    private final DescontoJpaRepository descontoRepository;

    public DeletarDescontoService(DescontoJpaRepository descontoRepository) {
        this.descontoRepository = descontoRepository;
    }

    public boolean deletar(Long id) {
        if (!descontoRepository.existsById(id)) {
            return false;
        }

        descontoRepository.deleteById(id);
        return true;
    }

}
