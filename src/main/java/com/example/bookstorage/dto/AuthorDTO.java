package com.example.bookstorage.dto;

import com.example.bookstorage.entity.Book;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class AuthorDTO {

    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    // @Temporal(TemporalType.DATE)
    @NotBlank
    private LocalDate birthDate;
    private List<Book> books;
}
