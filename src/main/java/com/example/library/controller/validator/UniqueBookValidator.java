package com.example.library.controller.validator;

import com.example.library.entity.Book;
import com.example.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
@RequiredArgsConstructor
public class UniqueBookValidator implements Validator {
    private final BookRepository bookRepository;
    @Override
    public boolean supports(Class<?> clazz) {
        return Book.class.equals(clazz);
    }


    @Override
    public void validate(Object target, Errors errors) {
        Book book = (Book) target;
        if (bookRepository.existsByNameAndAuthor(book.getName(), book.getAuthor())) {
            errors.rejectValue("name", "error.book.notUnique");
        }
    }
}
