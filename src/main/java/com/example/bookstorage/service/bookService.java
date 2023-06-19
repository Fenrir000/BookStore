package com.example.bookstorage.service;

import com.example.bookstorage.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface bookService {
    List<Book> findAll();


    Book findById(Long id);

    Book addBook(Book book);

    void deleteBookById(Long id);

    List<Book> findBooksByName(String name);

    Book createBook(Book book);

    Book updateBook(Book book);
}
