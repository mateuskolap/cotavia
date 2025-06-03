package br.com.pooj.cotavia.infra.persistence.repositories.destination;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pooj.cotavia.infra.persistence.entities.DestinationEntity;

public interface SpringDestinationJpaRepository extends JpaRepository<DestinationEntity, Long> {
    
}
