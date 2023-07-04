package com.example.bookstorage.repository;

import com.example.bookstorage.entity.Author;
import com.example.bookstorage.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRep extends JpaRepository<Book,Long> {
}
