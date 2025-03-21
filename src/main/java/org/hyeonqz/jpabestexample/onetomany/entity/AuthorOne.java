package org.hyeonqz.jpabestexample.onetomany.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@NamedEntityGraph(
        name = "author-books-graph",
        attributeNodes = {
                @NamedAttributeNode("bookOnes")
        }
)
@Entity
public class AuthorOne implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer age;

    private String genre;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author", orphanRemoval = true)
    private List<BookOne> bookOnes = new ArrayList<>();

    public void removeBook(BookOne bookOne) {
        bookOne.setAuthorOne(null);
        this.bookOnes.remove(bookOne);
    }

    public void removeBooks() {
        Iterator<BookOne> iterator = this.bookOnes.iterator();

        while(iterator.hasNext()) {
            BookOne bookOne = iterator.next();

            bookOne.setAuthorOne(null);
        }
    }

}
