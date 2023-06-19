package com.example.bookstorage.service;

import com.example.bookstorage.entity.Genre;
import org.springframework.stereotype.Service;

@Service
public interface genreService {
    Genre findGenreByName(String name);
    Genre updateGenre(Genre genre);

    Genre deleteGenre(Genre genre);

}
