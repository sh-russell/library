package com.example.library.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AttachBookDto {
    @NotNull
    private Integer personId;
    @NotNull
    private Integer bookId;
}
