package com.example.bookstorage.service;

import com.example.bookstorage.dto.GenreDTO;
import com.example.bookstorage.entity.Genre;
import com.example.bookstorage.repository.GenreRep;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.Optional;

public class GenreServiceImpl implements GenreService {
    private ModelMapper modelMapper;
    private GenreRep  genreRep;

    public GenreServiceImpl(ModelMapper modelMapper, GenreRep genreRep) {
        this.modelMapper = modelMapper;
        this.genreRep = genreRep;
    }

    @Transactional
    public GenreDTO findGenreByName(String name)  {
        //TODO throw GenreNotFoundException

        Optional<Genre> existingGenreOptional = genreRep.findById(name);
        Genre genre = existingGenreOptional.orElseThrow(GenreNotFoundException::new);

        return modelMapper.map(genre,GenreDTO.class);


    }

    @Transactional
    public GenreDTO updateGenre(String name,GenreDTO genreDTO) {
        Optional<Genre> existingGenreOptional = genreRep.findById(name);
        Genre genre=existingGenreOptional.orElseThrow(GenreNotFoundException::new);
        modelMapper.map(genreDTO, genre);
        genreRep.save(genre); //возможно это лишнее, потому что мы и так меняем genre  строчке выше, мод.маппер делает это через сеттеры
        GenreDTO updatedGenre =modelMapper.map(genre,GenreDTO.class);
        return updatedGenre;
    }

    @Transactional
    public void deleteGenreByName(String name) {
        genreRep.deleteById(name);

    }
}
