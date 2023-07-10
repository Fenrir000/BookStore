package com.example.bookstorage.repository;

import com.example.bookstorage.entity.Author;
import com.example.bookstorage.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRep extends JpaRepository<Book,Long> {

    List<Book> findAllByName(String name);
}
