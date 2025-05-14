package br.com.pooj.cotavia.application.services.cliente;

import br.com.pooj.cotavia.domain.model.Cliente;
import br.com.pooj.cotavia.infrastructure.persistence.mapper.ClienteMapper;
import br.com.pooj.cotavia.infrastructure.persistence.repository.ClienteJpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConsultarClientePorEmailService {
    private final ClienteJpaRepository clienteRepository;

    public ConsultarClientePorEmailService(ClienteJpaRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Optional<Cliente> consultarPorEmail(String email) {
        return clienteRepository.findByEmail(email)
                .map(ClienteMapper::toDomain);
    }
}
