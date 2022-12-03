package com.example.library.service;

import com.example.library.entity.Book;
import com.example.library.entity.Person;
import com.example.library.exception.NotFoundException;
import com.example.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Cache;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BookService {
    private static final Sort BY_YEAR = Sort.by("year");
    private final PersonService personService;
    private final BookRepository bookRepository;

    public List<Book> search(String bookName) {
        return bookRepository.findByNameStartsWithIgnoreCase(bookName);
    }

    public Page<Book> getAll(Integer page, Integer booksPerPage, boolean sortByYear) {
        if (sortByYear && booksPerPage != null && page != null) {
            return bookRepository.findAll(PageRequest.of(page, booksPerPage, BY_YEAR));
        }
        return bookRepository.findAll(PageRequest.of(page, booksPerPage));
    }

    @Cacheable("books")
    public Book getById(Integer id) {
        return bookRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public Book add(Book book) {
        return bookRepository.save(book);
    }

    @Transactional
    @CachePut(value = "books", key = "#book.id")
    public Book update(Book book) {
        Book dbBook = getById(book.getId());
        BeanUtils.copyProperties(book, dbBook, "id", "person");
        return dbBook;
    }

    @Transactional
    @CacheEvict(value = "books")
    public void delete(Integer id) {
        bookRepository.delete(getById(id));
    }

    @Transactional
    public void attach(Integer bookId, Integer personId) {
        Person person = personService.getById(personId);
        Book book = getById(bookId);
        book.setTakenAt(LocalDateTime.now());
        book.setPerson(person);
    }

    @Transactional
    public void release(Integer bookId) {
        Book book = getById(bookId);
        book.setPerson(null);
        book.setTakenAt(null);
    }
}
