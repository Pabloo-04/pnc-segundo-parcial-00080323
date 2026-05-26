package com.uca.pncsegundoparcialbiblioteca.mappers;

import com.uca.pncsegundoparcialbiblioteca.domain.dto.requests.BookRequest;
import com.uca.pncsegundoparcialbiblioteca.domain.dto.responses.BookResponse;
import com.uca.pncsegundoparcialbiblioteca.domain.entities.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public BookResponse toDto(Book entity){
        return BookResponse.builder().
                id(entity.getId())
                .genre(entity.getGenre())
                .isbn(entity.getIsbn())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .author(entity.getAuthor())
                .available(entity.getAvailable())
                .publishedDate(entity.getPublishedDate())
                .totalCopies(entity.getTotalCopies())
                .availableCopies(entity.getAvailableCopies()).build();
    }

    public Book toEntity(BookRequest request){
        return Book.builder().title(request.getTitle()).author(request.getAuthor())
                        .genre(request.getGenre()).isbn(request.getIsbn())
                        .availableCopies(request.getAvailableCopies())
                                .publishedDate(request.getPublishedDate())
                                        .totalCopies(request.getTotalCopies())
                .description(request.getDescription()).available(request.getAvailable()).build();
    }
}
