package br.com.pooj.cotavia.application.services.destino;

import br.com.pooj.cotavia.domain.model.Destino;
import br.com.pooj.cotavia.infrastructure.persistence.entity.DestinoEntity;
import br.com.pooj.cotavia.infrastructure.persistence.mapper.DestinoMapper;
import br.com.pooj.cotavia.infrastructure.persistence.repository.DestinoJpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AtualizarDestinoService {
    private final DestinoJpaRepository destinoRepository;

    public AtualizarDestinoService(DestinoJpaRepository destinoRepository) { this.destinoRepository = destinoRepository; }

    public Optional<Destino> atualizar(Long id, Destino novosDados) {
        Optional<DestinoEntity> destinoExistente = destinoRepository.findById(id);

        if (destinoExistente.isEmpty()) return Optional.empty();

        DestinoEntity destino = destinoExistente.get();
        destino.setNome(novosDados.getNome());
        destino.setDescricao(novosDados.getDescricao());
        destino.setLocalizacao(novosDados.getLocalizacao());
        destino.setPrecoPorPessoa(novosDados.getPrecoPorPessoa());

        DestinoEntity destinoAtualizado = destinoRepository.save(destino);
        return Optional.of(DestinoMapper.toDomain(destinoAtualizado));
    }
}
