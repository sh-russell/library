package com.example.library.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "people")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String fullName;
    @NotNull
    @Positive
    private Integer year;
    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
    private List<Book> books;
}
