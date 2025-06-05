package org.hyeonqz.jpabestexample.onetomany.repository;

import java.util.List;

import org.hyeonqz.jpabestexample.defaults.entity.Author;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true) // 인터페이스에서 등록하면 구현하는 클래스에서 적용할 필요가 없나?
@Repository // JpaRepository 에서 이미 빈 정의가 되어 있음 -> SimpleJpaRepository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @EntityGraph(value = "author-books-graph"
        ,type = EntityGraph.EntityGraphType.FETCH
    )
    List<Author> findByAgeLessThanOrderByNameDesc(int age);

    @EntityGraph(value = "author-books-graph"
            ,type = EntityGraph.EntityGraphType.FETCH
    )
    @Query(value = "select  a from AuthorOne a where a.age > 20 and a.age < 40")
    List<Author> fetchAllAgeBetween20And40();

}
