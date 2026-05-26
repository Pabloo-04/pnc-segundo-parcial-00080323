package com.uca.pncsegundoparcialbiblioteca.service.impl;

import com.uca.pncsegundoparcialbiblioteca.domain.dto.requests.BookRequest;
import com.uca.pncsegundoparcialbiblioteca.domain.dto.responses.BookResponse;
import com.uca.pncsegundoparcialbiblioteca.domain.dto.responses.PageableResponse;
import com.uca.pncsegundoparcialbiblioteca.mappers.BookMapper;
import com.uca.pncsegundoparcialbiblioteca.repository.BookRepository;
import com.uca.pncsegundoparcialbiblioteca.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    @Override
    public BookResponse createBook(BookRequest request) {

        return BookMapper.to
    }

    @Override
    public BookResponse updateBook(UUID id, BookRequest request) {
        return null;
    }

    @Override
    public PageableResponse<BookResponse> getBooks(int page, int size, String sortBy, String sortOrder) {
        return null;
    }

    @Override
    public BookResponse getBookById(UUID id) {
        return null;
    }

    @Override
    public BookResponse deleteBook(UUID id) {
        return null;
    }
}
