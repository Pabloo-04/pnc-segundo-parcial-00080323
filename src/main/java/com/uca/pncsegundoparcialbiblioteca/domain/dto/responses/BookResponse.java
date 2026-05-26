package com.uca.pncsegundoparcialbiblioteca.domain.dto.responses;

import com.uca.pncsegundoparcialbiblioteca.domain.entities.Genre;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {

    private UUID id;
    private String title;
    private String author;
    private String isbn;
    private Genre genre;
    private Integer totalCopies;
    private Integer availableCopies;
    private Boolean available;
    private Date publishedDate;
    private String description;
}
