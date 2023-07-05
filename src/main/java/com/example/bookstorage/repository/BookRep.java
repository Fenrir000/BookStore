package com.example.bookstorage.repository;

import com.example.bookstorage.entity.Author;
import com.example.bookstorage.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRep extends JpaRepository<Book,Long> {
    Optional<List<Book>> findAllBooks();
    Optional<List<Book>> findAllByName(String s);
}
