package org.hyeonqz.jpabestexample.defaults.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hyeonqz.jpabestexample.onetomany.entity.AuthorOne;

@Getter
@Entity
public class Book extends BaseEntity{

    private String title;

    private String isbn;

    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="author_id")
    private Author author;

}
