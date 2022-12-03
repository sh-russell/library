package com.example.library.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "books")
public class Book{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String name;
    @NotNull
    @Positive
    private Integer year;
    @NotBlank
    private String author;
    @ManyToOne
    private Person person;
    private LocalDateTime takenAt;

    public boolean isExpired(int days){
        return LocalDateTime.now().isAfter(takenAt.plusDays(10));
    }
}
