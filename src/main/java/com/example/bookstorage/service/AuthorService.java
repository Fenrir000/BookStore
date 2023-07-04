package com.example.bookstorage.service;

import com.example.bookstorage.dto.AuthorDTO;
import com.example.bookstorage.entity.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {
    List<Author> findAll();

    Author findById(Long id);

    Author addAuthor(Author author);

    void deleteAuthorById(Long id);

    List<Author> findAuthorsByName(String name);

    List<Author> findAuthorsByDateOfBirth(String dateOfBirth);

    Author createAuthor(Author author);

    Author updateAuthor(Author author);

}
