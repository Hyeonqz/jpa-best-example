package org.hyeonqz.jpabestexample.onetomany.service;

import org.hyeonqz.jpabestexample.onetomany.entity.AuthorOne;
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
        AuthorOne authorOne = authorRepository.findById(1L).orElse(null);

        authorRepository.delete(authorOne);
    }

    // orphanRemoval 사용 하여 삭제
    @Transactional
    public void useOrphanRemovalAuthor() {
        AuthorOne authorOne = authorRepository.findById(1L).orElse(null);

        authorRepository.deleteAllByIdInBatch();

        authorOne.removeBooks();
        authorRepository.delete(authorOne);
    }

}
