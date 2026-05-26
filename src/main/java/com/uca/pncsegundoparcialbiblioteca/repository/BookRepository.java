package com.uca.pncsegundoparcialbiblioteca.repository;

import com.uca.pncsegundoparcialbiblioteca.domain.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<UUID, Book> {
}
