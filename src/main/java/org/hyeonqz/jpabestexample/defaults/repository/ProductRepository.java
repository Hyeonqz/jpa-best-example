package org.hyeonqz.jpabestexample.defaults.repository;

import org.hyeonqz.jpabestexample.defaults.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
