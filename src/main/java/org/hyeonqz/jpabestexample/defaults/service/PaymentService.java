package org.hyeonqz.jpabestexample.defaults.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.hyeonqz.jpabestexample.defaults.entity.Payment;
import org.hyeonqz.jpabestexample.defaults.repository.PaymentRepository;
import org.hyeonqz.jpabestexample.defaults.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final ProductRepository productRepository;

    @PersistenceContext
    private final EntityManager em;

    @Transactional(readOnly = true)
    public void getProduct() {
        Payment payment = paymentRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
    }
}
