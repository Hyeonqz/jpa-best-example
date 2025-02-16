package org.hyeonqz.jpabestexample.nplus1.repository;

import org.hyeonqz.jpabestexample.nplus1.entity.NOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NOrderRepository extends JpaRepository<NOrder, Long> {
}
