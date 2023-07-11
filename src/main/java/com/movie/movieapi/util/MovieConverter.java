package com.movie.movieapi.util;

import com.movie.movieapi.dtos.MovieRequestDTO;
import com.movie.movieapi.entity.Category;
import com.movie.movieapi.entity.Movie;

public class MovieConverter {

    public static void convertDtoToEntity(MovieRequestDTO dto, Movie movie) {
        movie.setName(dto.getName());
        movie.setDirector(dto.getDirector());
        movie.setReleaseYear(dto.getReleaseYear());
        movie.setCategory(new Category(dto.getCategoryId()));
    }
}
