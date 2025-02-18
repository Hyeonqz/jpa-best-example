package org.hyeonqz.jpabestexample.onetomany.service;

import org.hyeonqz.jpabestexample.onetomany.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthorService {
    private final AuthorRepository authorRepository;


}
