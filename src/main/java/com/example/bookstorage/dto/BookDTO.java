package com.example.bookstorage.dto;

import com.example.bookstorage.entity.Author;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
public class BookDTO {


    @NotBlank
    private String name;
    @Min(1)
    @NotBlank
    private int pages;

    private List<Author> authors;
}
