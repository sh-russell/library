package com.example.library.service;

import com.example.library.entity.Person;
import com.example.library.exception.NotFoundException;
import com.example.library.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public Person getById(Integer id) {
        return personRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public Person add(Person person) {
        if (personRepository.existsByFullName(person.getFullName())) {
            throw new RuntimeException("user with this full name exists");
        }
        return personRepository.save(person);
    }

    @Transactional
    public Person update(Person person) {
        if (person.getId() == null) {
            throw new RuntimeException("id must not be null");
        }

        if (!personRepository.existsById(person.getId())) {
            throw new RuntimeException("user with this id doesn't exist");
        }

        return personRepository.save(person);
    }
    @Transactional
    public void delete(Integer id) {
        personRepository.delete(getById(id));
    }
}
