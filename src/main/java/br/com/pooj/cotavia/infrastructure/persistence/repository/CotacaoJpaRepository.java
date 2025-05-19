package br.com.pooj.cotavia.infrastructure.persistence.repository;

import br.com.pooj.cotavia.infrastructure.persistence.entity.CotacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CotacaoJpaRepository extends JpaRepository<CotacaoEntity, Long> {
}
