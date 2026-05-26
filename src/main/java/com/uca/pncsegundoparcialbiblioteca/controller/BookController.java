package com.uca.pncsegundoparcialbiblioteca.controller;

import com.uca.pncsegundoparcialbiblioteca.domain.dto.requests.BookRequest;
import com.uca.pncsegundoparcialbiblioteca.domain.dto.responses.BookResponse;
import com.uca.pncsegundoparcialbiblioteca.domain.dto.responses.GeneralResponse;
import com.uca.pncsegundoparcialbiblioteca.domain.entities.Genre;
import com.uca.pncsegundoparcialbiblioteca.service.BookService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/specimens")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<GeneralResponse> createBook(
            HttpServletRequest request,
            @Valid @RequestBody BookRequest body
    ) {

        BookResponse response = bookService.createBook(body);

        return buildResponse(request,"Book created.", HttpStatus.CREATED, response);
    }


    @GetMapping
    public ResponseEntity<GeneralResponse> getAllSpecimens(
            HttpServletRequest request,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortOrder,
            @RequestParam Genre genre,
            @RequestParam Boolean available
    ) {

        return buildResponse(
                request,
                "Books were found",
                HttpStatus.OK,
                bookService.getBooks(page, size, sortBy, sortOrder, genre, )
        );
    }


    @GetMapping("/{id}")
    public ResponseEntity<GeneralResponse> getSpecimenById(
            HttpServletRequest request,
            @PathVariable UUID id
    ) {
        return buildResponse(request, "Book with " + id.toString() + " was found"
                ,HttpStatus.OK,
                bookService.getBookById(id)
        );

    }

    @PutMapping("/{id}")
    public ResponseEntity<GeneralResponse> updateSpecimen(
            HttpServletRequest request,
            @PathVariable UUID id,
            @Valid @RequestBody BookRequest body
    ) {
        return  buildResponse(request,"Book updated",HttpStatus.OK,bookService.updateBook(id,body));

    }

    private ResponseEntity<GeneralResponse> buildResponse(
            HttpServletRequest request,
            String message,
            HttpStatus status,
            Object data
    ) {

        GeneralResponse response = GeneralResponse.builder()
                .uri(request.getRequestURI())
                .message(message)
                .status(status.value())
                .time(LocalDateTime.now())
                .data(data)
                .build();

        return ResponseEntity.status(status).body(response);
    }
}
