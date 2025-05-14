package br.com.pooj.cotavia.application.services.cliente;

import br.com.pooj.cotavia.domain.model.Cliente;
import br.com.pooj.cotavia.infrastructure.persistence.entity.ClienteEntity;
import br.com.pooj.cotavia.infrastructure.persistence.mapper.ClienteMapper;
import br.com.pooj.cotavia.infrastructure.persistence.repository.ClienteJpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AtualizarClienteService {
    private final ClienteJpaRepository clienteRepository;

    public AtualizarClienteService(ClienteJpaRepository clienteRepository) { this.clienteRepository = clienteRepository; }

    public Optional<Cliente> atualizar(Long id, Cliente novosDados) {
        Optional<ClienteEntity> clienteExistente = clienteRepository.findById(id);

        if (clienteExistente.isEmpty()) return Optional.empty();

        ClienteEntity cliente = clienteExistente.get();
        cliente.setNome(novosDados.getNome());
        cliente.setEmail(novosDados.getEmail());
        cliente.setTelefone(novosDados.getTelefone());
        cliente.setDocumento(novosDados.getDocumento());

        ClienteEntity clienteAtualizado = clienteRepository.save(cliente);
        return Optional.of(ClienteMapper.toDomain(clienteAtualizado));
    }
}
