package com.movie.movieapi.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.movie.movieapi.entity.Movie;

public class MovieResponseDTO {
    private Long id;

    private String name;

    private String director;

    private Integer releaseYear;

    @JsonProperty("Category")
    private CategoryResponseDTO categoryResponseDTO;

    public MovieResponseDTO() {
    }

    public MovieResponseDTO(Movie movie) {
        this.id = movie.getId();
        this.name = movie.getName();
        this.director = movie.getDirector();
        this.releaseYear = movie.getReleaseYear();
        this.categoryResponseDTO = new CategoryResponseDTO(movie.getCategory());
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

    public CategoryResponseDTO getCategoryResponseDTO() {
        return categoryResponseDTO;
    }

    public void setCategoryResponseDTO(CategoryResponseDTO categoryResponseDTO) {
        this.categoryResponseDTO = categoryResponseDTO;
    }
}
