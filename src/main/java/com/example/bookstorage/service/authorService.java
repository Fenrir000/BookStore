package com.example.bookstorage.service;

import com.example.bookstorage.entity.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface authorService {
     List<Author> findAll();


}
