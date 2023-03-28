package com.movie.movieapi.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.movie.movieapi.entity.Movie;

import javax.validation.constraints.NotBlank;

public class MovieDTO {
    private Long id;

    @NotBlank(message = "Movie name with invalid format.")
    private String name;

    @JsonProperty("Category")
    private CategoryDTO categoryDTO;

    public MovieDTO() {
    }

    public MovieDTO(Movie movie) {
        this.id = movie.getId();
        this.name = movie.getName();
        categoryDTO = new CategoryDTO(movie.getCategory());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }
}
