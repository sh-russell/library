package com.example.library.repository;

import com.example.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    boolean existsByNameAndAuthor(String name, String author);
    List<Book> findByNameStartsWithIgnoreCase(String bookName);
}

