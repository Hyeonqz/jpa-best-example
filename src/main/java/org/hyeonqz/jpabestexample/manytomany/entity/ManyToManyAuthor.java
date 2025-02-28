package org.hyeonqz.jpabestexample.manytomany.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class ManyToManyAuthor implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String genre;
    private int age;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="many_to_many_author",
        joinColumns = @JoinColumn(name="many_to_many_author_id"),
            inverseJoinColumns = @JoinColumn(name = "many_to_many_book_id")
    )
    private Set<ManyToManyBook> books = new HashSet<>();

    public void addBook(ManyToManyBook book) {
        this.books.add(book);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ManyToManyAuthor that))
            return false;
        return age == that.age && Objects.equals(id, that.id) && Objects.equals(name, that.name)
                && Objects.equals(genre, that.genre) && Objects.equals(books, that.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, genre, age, books);
    }

    @Override
    public String toString() {
        return "ManyToManyAuthor{" +
                "age=" + age +
                ", genre='" + genre + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

}
