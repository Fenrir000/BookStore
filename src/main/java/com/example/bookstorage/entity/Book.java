package com.example.bookstorage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Book")
@Data
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String name;
    @Min(1)
    private int pages;

    private int year;
    @JsonIgnore
    @ManyToMany(mappedBy = "books")
    private List<Author> authors;

    @ManyToMany(mappedBy = "books")
    private List<Genre> genres;
}
