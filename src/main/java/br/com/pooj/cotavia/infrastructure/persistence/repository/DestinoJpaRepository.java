package br.com.pooj.cotavia.infrastructure.persistence.repository;

import br.com.pooj.cotavia.infrastructure.persistence.entity.DestinoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinoJpaRepository extends JpaRepository<DestinoEntity, Long> {
}
