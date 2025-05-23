package br.com.pooj.cotavia.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pooj.cotavia.infrastructure.persistence.entity.DescontoEntity;

public interface DescontoJpaRepository extends JpaRepository<DescontoEntity, Long> {
}
