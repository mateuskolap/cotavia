package br.com.pooj.cotavia.infra.persistence.repositories.quote;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pooj.cotavia.infra.persistence.entities.QuoteEntity;

public interface SpringQuoteJpaRepository extends JpaRepository<QuoteEntity, Long> {
    
}
