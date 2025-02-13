package org.hyeonqz.jpabestexample.onetomany.repository;

import org.hyeonqz.jpabestexample.onetomany.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
