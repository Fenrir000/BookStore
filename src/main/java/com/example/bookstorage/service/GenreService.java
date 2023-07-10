package com.example.bookstorage.service;

import com.example.bookstorage.dto.GenreDTO;
import com.example.bookstorage.entity.Genre;
import org.springframework.stereotype.Service;


public interface GenreService {
    GenreDTO findGenreByName(String name) throws Exception;
    GenreDTO updateGenre(String name,GenreDTO genreDTO);

    void deleteGenreByName(String name);

}
