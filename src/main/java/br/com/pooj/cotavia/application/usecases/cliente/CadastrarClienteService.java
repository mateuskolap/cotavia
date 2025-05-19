package br.com.pooj.cotavia.application.usecases.cliente;

import br.com.pooj.cotavia.domain.model.Cliente;
import br.com.pooj.cotavia.infrastructure.persistence.entity.ClienteEntity;
import br.com.pooj.cotavia.infrastructure.persistence.mapper.ClienteEntityMapper;
import br.com.pooj.cotavia.infrastructure.persistence.repository.ClienteJpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CadastrarClienteService {
    private final ClienteJpaRepository clienteRepository;

    public CadastrarClienteService(ClienteJpaRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente cadastrar(Cliente cliente) {
        ClienteEntity salvo = clienteRepository.save(ClienteEntityMapper.toEntity(cliente));
        return ClienteEntityMapper.toDomain(salvo);
    }
}
