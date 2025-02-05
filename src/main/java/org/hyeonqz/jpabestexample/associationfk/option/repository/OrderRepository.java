package org.hyeonqz.jpabestexample.associationfk.option.repository;

import org.hyeonqz.jpabestexample.associationfk.option.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
