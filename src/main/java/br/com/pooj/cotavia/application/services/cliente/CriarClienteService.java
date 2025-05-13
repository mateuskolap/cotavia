package br.com.pooj.cotavia.application.services.cliente;

import br.com.pooj.cotavia.domain.model.Cliente;
import br.com.pooj.cotavia.infrastructure.persistence.entity.ClienteEntity;
import br.com.pooj.cotavia.infrastructure.persistence.mapper.ClienteMapper;
import br.com.pooj.cotavia.infrastructure.persistence.repository.ClienteJpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CriarClienteService {
    private final ClienteJpaRepository clienteRepository;

    public CriarClienteService(ClienteJpaRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente criar(Cliente cliente) {
        ClienteEntity salvo = clienteRepository.save(ClienteMapper.toEntity(cliente));
        return ClienteMapper.toDomain(salvo);
    }
}
