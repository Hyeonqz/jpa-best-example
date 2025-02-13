package org.hyeonqz.jpabestexample.onetomany.repository;

import org.hyeonqz.jpabestexample.onetomany.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
