package org.hyeonqz.jpabestexample.onetomany.service;

import org.hyeonqz.jpabestexample.defaults.entity.Author;
import org.hyeonqz.jpabestexample.onetomany.entity.AuthorOne;
import org.hyeonqz.jpabestexample.onetomany.entity.BookOne;
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
        Author authorOne = authorRepository.getReferenceById(4L);

        BookOne bookOne = new BookOne();
        bookOne.setIsbn("003-JIN");
        bookOne.setTitle("hi");

        bookRepository.save(bookOne);

        bookOne.setIsbn("hi?");
    }

}
