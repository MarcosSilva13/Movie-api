package com.movie.movieapi.controller;

import com.movie.movieapi.entity.Movie;
import com.movie.movieapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> findAll() {
        List<Movie> movies = movieService.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(movies);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Movie> findById(@PathVariable Long id) {
        Movie movie = movieService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(movie);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Movie> insert(@RequestBody Movie movie) {
        Movie movieSaved = movieService.insert(movie);

        return ResponseEntity.status(HttpStatus.CREATED).body(movieSaved);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Movie> update(@RequestBody Movie movie) {
        Movie movieUpdated = movieService.update(movie.getId(), movie.getName(), movie.getCategory());

        return ResponseEntity.status(HttpStatus.OK).body(movieUpdated);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        movieService.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
    }
}
