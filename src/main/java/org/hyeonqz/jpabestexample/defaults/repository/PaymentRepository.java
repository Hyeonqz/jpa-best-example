package org.hyeonqz.jpabestexample.defaults.repository;

import org.hyeonqz.jpabestexample.defaults.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
