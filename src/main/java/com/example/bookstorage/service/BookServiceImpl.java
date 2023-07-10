package com.example.bookstorage.service;

import com.example.bookstorage.dto.BookDTO;
import com.example.bookstorage.entity.Book;
import com.example.bookstorage.exceptions.BookNotFoundException;
import com.example.bookstorage.repository.BookRep;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class BookServiceImpl implements BookService {
    private final BookRep bookRep;
    private final ModelMapper modelMapper;

    public BookServiceImpl(BookRep bookRep, ModelMapper modelMapper) {
        this.bookRep = bookRep;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public List<BookDTO> findAll() {
        List<Book> books = bookRep.findAll();
        if (books.isEmpty()) {
            throw new BookNotFoundException();
        }
        return books.stream()
                .map(book -> modelMapper.map(book, BookDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public BookDTO findById(Long id) {
        Book book=bookRep.findById(id).orElseThrow(BookNotFoundException::new);
        return  modelMapper.map(book, BookDTO.class);

    }

    @Transactional
    public BookDTO addBook(BookDTO bookDTO) {
        Book toBeSaved= modelMapper.map(bookDTO,Book.class);
        return modelMapper.map(bookRep.save(toBeSaved),BookDTO.class);
    }

    @Transactional
    public void deleteBookById(Long id) {
        bookRep.deleteById(id);

    }

    @Transactional
    public List<BookDTO> findBooksByName(String name) {
        List<Book> books = bookRep.findAllByName(name);
        if (books.isEmpty()) {
            throw new BookNotFoundException();
        }
        return books.stream()
                .map(book -> modelMapper.map(book, BookDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public BookDTO updateBook(Long id,BookDTO bookDTO) {
        Book existingBook =bookRep.findById(id).orElseThrow(BookNotFoundException::new);
        modelMapper.map(bookDTO,existingBook);
        return modelMapper.map(existingBook,BookDTO.class);
    }
}
