package org.hyeonqz.jpabestexample.onetomany.service;

import org.hyeonqz.jpabestexample.defaults.entity.Author;
import org.hyeonqz.jpabestexample.onetomany.entity.AuthorOne;
import org.hyeonqz.jpabestexample.onetomany.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    // cascadeType 사용 하여 삭제
    @Transactional
    public void deleteAuthor() {
        Author authorOne = authorRepository.findById(1L).orElse(null);

        authorRepository.delete(authorOne);
    }

    // orphanRemoval 사용 하여 삭제
    @Transactional
    public void useOrphanRemovalAuthor() {
        Author authorOne = authorRepository.findById(1L).orElse(null);

        authorRepository.deleteAllByIdInBatch(List.of(authorOne.getBooks().get(1).getId()));

        //authorOne.removeBooks();
        authorRepository.delete(authorOne);
    }

}
