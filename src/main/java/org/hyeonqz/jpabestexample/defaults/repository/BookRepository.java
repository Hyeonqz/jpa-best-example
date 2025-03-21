package org.hyeonqz.jpabestexample.defaults.repository;

import org.hyeonqz.jpabestexample.defaults.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly=true)
public interface BookRepository extends JpaRepository<Book, Long> {

}
