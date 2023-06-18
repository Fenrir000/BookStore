package com.example.bookstorage.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Genre")
@Data
@NoArgsConstructor
public class Genre {
    @Id
    @NotBlank
    private String name;
    @ManyToMany
    @JoinTable(name = "book_genre",
            joinColumns = @JoinColumn(name = "genre_name"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    List<Book> books;
}
