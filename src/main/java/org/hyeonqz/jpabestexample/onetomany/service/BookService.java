package org.hyeonqz.jpabestexample.onetomany.service;

import org.hyeonqz.jpabestexample.onetomany.entity.Author;
import org.hyeonqz.jpabestexample.onetomany.entity.Book;
import org.hyeonqz.jpabestexample.onetomany.repository.AuthorRepository;
import org.hyeonqz.jpabestexample.onetomany.repository.BookRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public void insertNewBook() {
        Author author = authorRepository.getReferenceById(4L);

        Book book = new Book();
        book.setIsbn("003-JIN");
        book.setTitle("hi");
        book.setAuthor(author);

        bookRepository.save(book);

        book.setIsbn("hi?");
    }

}
