package com.example.bookstorage.dto;

import com.example.bookstorage.entity.Book;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
public class GenreDTO {

    @NotBlank
    private String name;

    List<Book> books;
}
