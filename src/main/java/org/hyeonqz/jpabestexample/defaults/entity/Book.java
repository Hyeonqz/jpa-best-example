package org.hyeonqz.jpabestexample.defaults.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hyeonqz.jpabestexample.onetomany.entity.AuthorOne;

@Getter
@Entity
public class Book {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String isbn;

    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="author_id")
    private Author author;

    @Override
    public String toString() {
        // 연관 객체를 제외시켜야 한다.
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }

}
