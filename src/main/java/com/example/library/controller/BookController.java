package com.example.library.controller;

import com.example.library.controller.validator.UniqueBookValidator;
import com.example.library.dto.AttachBookDto;
import com.example.library.entity.Book;
import com.example.library.service.BookService;
import com.example.library.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private final PersonService personService;
    private final UniqueBookValidator uniqueBookValidator;

//    @InitBinder
//    public void init(WebDataBinder dataBinder) {
//        dataBinder.setValidator(uniqueBookValidator);
//    }

    @GetMapping("/search")
    public String search(@RequestParam String bookName, Model model) {
        model.addAttribute("books", bookService.search(bookName));
        return "search";
    }

    @GetMapping
    public String getAll(@RequestParam(defaultValue = "0") Integer page,
                         @RequestParam(name = "books_per_page", defaultValue = "10") Integer booksPerPage,
                         @RequestParam(name = "sort_by_year", required = false, defaultValue = "true") boolean sortByYear,
                         Model model) {
        Page<Book> bookPage = bookService.getAll(page, booksPerPage, sortByYear);
        model.addAttribute("page", bookPage);
        return "books";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id, Model model) {
        model.addAttribute("people", personService.getAll());
        model.addAttribute("book", bookService.getById(id));
        model.addAttribute("attachBook", new AttachBookDto());
        return "book";
    }

    @GetMapping("/new")
    public String add(@ModelAttribute Book book) {
//        model.addAttribute("book", new Book());
        return "bookForm";
    }

    @PostMapping("/new")
    public String create(@Valid @ModelAttribute Book book, BindingResult bindingResult) {
        uniqueBookValidator.validate(book, bindingResult);
        if (bindingResult.hasErrors()) {
            return "bookForm";
        }
        bookService.add(book);
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("book", bookService.getById(id));
        return "bookForm";
    }

    @PostMapping("/edit")
    public String edit(@Valid Book book, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "bookForm";
        }
        model.addAttribute("book", bookService.update(book));
        return "redirect:/books";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Integer id) {
        bookService.delete(id);
        return "redirect:/books";
    }

    @PostMapping("/attach")
    public String attach(@Valid AttachBookDto attachBook, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "book";
        }
        bookService.attach(attachBook.getBookId(), attachBook.getPersonId());
        return "redirect:/books/" + attachBook.getBookId();
    }

    @GetMapping("/{id}/release")
    public String release(@PathVariable Integer id) {
        bookService.release(id);
        return "redirect:/books/" + id;
    }
}
