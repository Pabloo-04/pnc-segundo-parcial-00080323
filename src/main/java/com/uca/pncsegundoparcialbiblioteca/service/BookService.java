package com.uca.pncsegundoparcialbiblioteca.service;

import com.uca.pncsegundoparcialbiblioteca.domain.dto.requests.BookRequest;
import com.uca.pncsegundoparcialbiblioteca.domain.dto.responses.BookResponse;
import com.uca.pncsegundoparcialbiblioteca.domain.dto.responses.PageableResponse;
import com.uca.pncsegundoparcialbiblioteca.domain.entities.Book;
import org.hibernate.query.Page;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface BookService {
    BookResponse createBook(BookRequest request);
    BookResponse updateBook(UUID id, BookRequest request);
    PageableResponse<BookResponse> getBooks(int page, int size, String sortBy, String sortOrder);
    BookResponse getBookById(UUID id);
    BookResponse deleteBook(UUID id);
}
