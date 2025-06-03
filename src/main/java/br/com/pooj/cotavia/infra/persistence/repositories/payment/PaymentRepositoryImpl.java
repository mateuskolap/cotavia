package br.com.pooj.cotavia.infra.persistence.repositories.payment;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.pooj.cotavia.core.models.Payment;
import br.com.pooj.cotavia.core.repositories.PaymentRepository;
import br.com.pooj.cotavia.infra.persistence.entities.PaymentEntity;
import br.com.pooj.cotavia.infra.persistence.mappers.PaymentMapper;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class PaymentRepositoryImpl implements PaymentRepository {
    private final SpringPaymentJpaRepository jpaRepository;
    private final PaymentMapper paymentMapper;

    @Override
    public Payment save(Payment payment) {
        PaymentEntity entity = paymentMapper.toEntity(payment);
        PaymentEntity saved = jpaRepository.save(entity);

        return paymentMapper.toModel(saved);
    }

    @Override
    public Optional<Payment> findById(Long id) {
        return jpaRepository.findById(id)
                            .map(paymentMapper::toModel);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaRepository.existsById(id);
    }
}
