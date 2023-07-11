package com.movie.movieapi.dtos;

import javax.validation.constraints.NotBlank;

public class CategoryRequestDTO {

    @NotBlank(message = "Category name with invalid format.")
    private String name;

    public CategoryRequestDTO() {
    }

    public CategoryRequestDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
