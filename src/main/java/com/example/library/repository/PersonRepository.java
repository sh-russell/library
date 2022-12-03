package com.example.library.repository;
import com.example.library.entity.Person;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Optional<Person> findByFullName(String fullName);
    boolean existsByFullName(String fullName);
}
