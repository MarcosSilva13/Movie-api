package com.movie.movieapi.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class MovieRequestDTO {

    @NotBlank(message = "Movie name with invalid format.")
    private String name;

    @NotBlank(message = "Movie director with invalid format.")
    private String director;

    @NotNull(message = "Movie releaseYear with invalid format.")
    private Integer releaseYear;

    @NotNull(message = "Category id cannot be null.")
    private Long categoryId;

    public MovieRequestDTO() {
    }

    public MovieRequestDTO(String name, String director, Integer releaseYear, Long categoryId) {
        this.name = name;
        this.director = director;
        this.releaseYear = releaseYear;
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
