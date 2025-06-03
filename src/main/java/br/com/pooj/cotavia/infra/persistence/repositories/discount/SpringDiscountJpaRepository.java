package br.com.pooj.cotavia.infra.persistence.repositories.discount;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pooj.cotavia.infra.persistence.entities.DiscountEntity;

public interface SpringDiscountJpaRepository extends JpaRepository<DiscountEntity, Long> {
    List<DiscountEntity> findAllByQuote_Id(Long quoteId);
}
