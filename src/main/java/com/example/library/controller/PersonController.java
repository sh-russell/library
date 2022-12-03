package com.example.library.controller;

import com.example.library.entity.Person;
import com.example.library.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/people")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("people", personService.getAll());
        return "people";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id, Model model) {
        model.addAttribute("person", personService.getById(id));
        return "person";
    }

    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("person", new Person());
        return "personForm";
    }

    @PostMapping("/new")
    public String create(@Valid @ModelAttribute Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "personForm";
        }
        personService.add(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("person", personService.getById(id));
        return "personForm";
    }

    @PostMapping("/edit")
    public String edit(@Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "personForm";
        }
        personService.update(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Integer id) {
        personService.delete(id);
        return "redirect:/people";
    }
}
