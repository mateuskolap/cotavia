package br.com.pooj.cotavia.application.services.cliente;

import br.com.pooj.cotavia.domain.model.Cliente;
import br.com.pooj.cotavia.infrastructure.persistence.mapper.ClienteMapper;
import br.com.pooj.cotavia.infrastructure.persistence.repository.ClienteJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarClientesService {
    private final ClienteJpaRepository clienteRepository;

    public ListarClientesService(ClienteJpaRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll()
                .stream()
                .map(ClienteMapper::toDomain)
                .collect(Collectors.toList());
    }
}
