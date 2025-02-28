package org.hyeonqz.jpabestexample.onetomany.service;

import org.hyeonqz.jpabestexample.onetomany.entity.Author;
import org.hyeonqz.jpabestexample.onetomany.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    // cascadeType 사용 하여 삭제
    @Transactional
    public void deleteAuthor() {
        Author author = authorRepository.findById(1L).orElse(null);

        authorRepository.delete(author);
    }

    // orphanRemoval 사용 하여 삭제
    @Transactional
    public void useOrphanRemovalAuthor() {
        Author author = authorRepository.findById(1L).orElse(null);

        authorRepository.deleteAllByIdInBatch();

        author.removeBooks();
        authorRepository.delete(author);
    }

}
