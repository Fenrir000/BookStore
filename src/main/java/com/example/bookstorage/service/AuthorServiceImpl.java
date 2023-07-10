package com.example.bookstorage.service;

import com.example.bookstorage.dto.AuthorDTO;
import com.example.bookstorage.entity.Author;
import com.example.bookstorage.exceptions.AuthorNotFoundException;
import com.example.bookstorage.repository.AuthorRep;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRep authorRep;
    private final ModelMapper modelMapper;

    public AuthorServiceImpl(AuthorRep authorRep, ModelMapper modelMapper) {
        this.authorRep = authorRep;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public List<AuthorDTO> findAll() {
        List<Author> authors=authorRep.findAll();

       /* return authors.stream().
                map(author -> modelMapper.map(author, AuthorDTO.class)).
                toList();*/
        List<AuthorDTO> res=new ArrayList<>();
        for(Author a : authors){
            res.add(modelMapper.map(a, AuthorDTO.class));
        }
        return res;
    }

    @Transactional
    public AuthorDTO findById(Long id) {
        return modelMapper.map(authorRep.
                findById(id).
                orElseThrow(AuthorNotFoundException::new), AuthorDTO.class);
    }

    @Transactional
    public AuthorDTO addAuthor(AuthorDTO authorDTO) {
        Author newAuthor=modelMapper.map(authorDTO, Author.class);
        return modelMapper.
                map(authorRep.save(newAuthor),AuthorDTO.class);

    }

    @Transactional
    public void deleteAuthorById(Long id) {
        authorRep.deleteById(id);

    }

    @Transactional
    public List<AuthorDTO> findAuthorsByName(String name) {
        return authorRep.findAuthorsByName(name).
                stream().map(author -> (modelMapper.map(author, AuthorDTO.class))).
                toList();
    }

  /*  @Transactional
    public List<AuthorDTO> findAuthorsByDateOfBirth(LocalDate birthDate) {
        return authorRep.findAuthorsByBirthDate( birthDate).
                stream().map(author -> (modelMapper.map(author, AuthorDTO.class))).
                toList();
    }*/



    @Transactional
    public AuthorDTO updateAuthor(Long id, AuthorDTO authorDTO) {
        Author existingAuthor= authorRep.findById(id).orElseThrow(AuthorNotFoundException::new);
        modelMapper.map(authorDTO,existingAuthor);
        return modelMapper.map(existingAuthor,AuthorDTO.class);
    }
}
