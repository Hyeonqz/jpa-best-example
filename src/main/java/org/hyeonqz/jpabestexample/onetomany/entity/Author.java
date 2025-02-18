package org.hyeonqz.jpabestexample.onetomany.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Author implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer age;

    private String genre;

    private String name;

/*    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author", orphanRemoval = true)
    //@OrderColumn(name="books_order")
    @JoinColumn(name="author_id")
    private List<Book> books = new ArrayList<>();*/
}
