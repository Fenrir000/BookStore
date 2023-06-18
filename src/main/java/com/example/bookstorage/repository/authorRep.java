package com.example.bookstorage.repository;

import com.example.bookstorage.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface authorRep extends JpaRepository<Author,Long> {
}