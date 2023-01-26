package com.movie.movieapi.service;

import com.movie.movieapi.entity.Category;
import com.movie.movieapi.entity.Movie;
import com.movie.movieapi.repository.MovieRepository;
import com.movie.movieapi.service.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Movie findById(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ID: " + id + " não encontrado!"));
    }

    public Movie insert(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie update(Long id, String name, Category category) {
        Movie mov = movieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ID: " + id + " não encontrado!"));

        mov.setName(name);
        mov.setCategory(category);

        return movieRepository.save(mov);
    }

    public void deleteById(Long id) {
        movieRepository.deleteById(movieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ID: " + id + " não encontrado!")).getId());
    }
}
