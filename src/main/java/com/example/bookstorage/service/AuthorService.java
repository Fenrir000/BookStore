package com.example.bookstorage.service;

import com.example.bookstorage.dto.AuthorDTO;
import com.example.bookstorage.entity.Author;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AuthorService {
    List<AuthorDTO> findAll();

    AuthorDTO findById(Long id);

    AuthorDTO addAuthor(AuthorDTO authorDTO);

    void deleteAuthorById(Long id);

  List<AuthorDTO> findAuthorsByName(String name);

   /* List<AuthorDTO> findAuthorsByDateOfBirth(String dateOfBirth);*/



    AuthorDTO updateAuthor(Long id,AuthorDTO authorDTO);

}
