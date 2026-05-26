package com.uca.pncsegundoparcialbiblioteca.domain.dto.requests;


import com.uca.pncsegundoparcialbiblioteca.domain.entities.Genre;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Author is required")
    private String author;

    @NotBlank(message = "ISBN is required")
    @Pattern(
            regexp = "^(97(8|9))?\\d{9}(\\d|X)$",
            message = "Invalid ISBN format"
    )
    private String isbn;

    @NotNull(message = "Genre is required")
    private Genre genre;

    @NotNull(message = "Total copies is required")
    @Min(value = 1, message = "Number of copies must be greater than zero")
    private Integer totalCopies;

    private Integer availableCopies;

    private Boolean available;

    @PastOrPresent(message = "Published date cannot be in the future")
    private Date publishedDate;

    private String description;
}
