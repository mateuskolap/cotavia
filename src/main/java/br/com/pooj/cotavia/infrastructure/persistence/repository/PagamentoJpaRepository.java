package br.com.pooj.cotavia.infrastructure.persistence.repository;

import br.com.pooj.cotavia.infrastructure.persistence.entity.PagamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoJpaRepository extends JpaRepository<PagamentoEntity, Long> {
}
