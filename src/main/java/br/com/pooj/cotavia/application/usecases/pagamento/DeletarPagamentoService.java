package br.com.pooj.cotavia.application.usecases.pagamento;

import br.com.pooj.cotavia.infrastructure.persistence.repository.PagamentoJpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DeletarPagamentoService {
    private final PagamentoJpaRepository pagamentoRepository;

    public DeletarPagamentoService(PagamentoJpaRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    public boolean deletar(Long id) {
        if (!pagamentoRepository.existsById(id)) {
            return false;
        }

        pagamentoRepository.deleteById(id);
        return true;
    }
}
