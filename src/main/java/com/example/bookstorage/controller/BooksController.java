package com.example.bookstorage.controller;

import com.example.bookstorage.dto.BookDTO;
import com.example.bookstorage.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {
private BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public ResponseEntity<List<BookDTO>> findAll(){
       List<BookDTO> booksDTO= bookService.findAll();
        return ResponseEntity.ok(booksDTO);
    }
    @GetMapping("/{id}")
    public  ResponseEntity<BookDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(bookService.findById(id));
    }
    @PostMapping()
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.addBook(bookDTO));

    }
    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id,@RequestBody BookDTO bookDTO){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.updateBook(id,bookDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return ResponseEntity.noContent().build();
    }

}
