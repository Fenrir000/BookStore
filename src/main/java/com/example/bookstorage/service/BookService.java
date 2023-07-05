package com.example.bookstorage.service;

import com.example.bookstorage.dto.BookDTO;
import com.example.bookstorage.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<BookDTO> findAll();


    BookDTO findById(Long id);

    BookDTO addBook(BookDTO bookDTO);

    void deleteBookById(Long id);

    List<BookDTO> findBooksByName(String name);
    
    BookDTO updateBook(Long id,BookDTO bookDTO);
}
