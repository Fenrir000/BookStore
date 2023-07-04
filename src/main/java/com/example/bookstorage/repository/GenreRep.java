package com.example.bookstorage.repository;

import com.example.bookstorage.entity.Author;
import com.example.bookstorage.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRep extends JpaRepository<Genre,String> {

}
