package com.movie.movieapi.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.movie.movieapi.entity.Movie;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class MovieDTO {
    private Long id;

    @NotBlank(message = "Movie name with invalid format.")
    private String name;

    @NotNull(message = "Movie releaseYear with invalid format.")
    private Integer releaseYear;

    @JsonProperty("Category")
    private CategoryDTO categoryDTO;

    public MovieDTO() {
    }

    public MovieDTO(Movie movie) {
        this.id = movie.getId();
        this.name = movie.getName();
        this.releaseYear = movie.getReleaseYear();
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

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }
}
