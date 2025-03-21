package org.hyeonqz.jpabestexample.defaults.repository;

import org.hyeonqz.jpabestexample.defaults.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly=true)
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    // inner join
    @Query("select a from Author a inner join a.books b " + "where b.price >?1")
    List<Author> fetchAuthorsBooksByPriceInnerJoin(int price);

    // fetch join
    @Query("select a from Author a join fetch a.books b where b.price > ?1")
    List<Author> fetchAuthorsBooksByPriceJoinFetch(int price);

}
