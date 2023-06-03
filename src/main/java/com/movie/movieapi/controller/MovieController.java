package com.movie.movieapi.controller;

import com.movie.movieapi.dtos.MovieDTO;
import com.movie.movieapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.findAll());
    }

    @GetMapping(value = "/sortByName")
    public ResponseEntity<List<MovieDTO>> findOrderByName() {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.findOrderByName());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MovieDTO> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.findById(id));
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<List<MovieDTO>> findByName(@PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.findByName(name));
    }

    @PostMapping
    public ResponseEntity<MovieDTO> insert(@RequestBody @Valid MovieDTO movieDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.insert(movieDTO));
    }

    @PutMapping
    public ResponseEntity<MovieDTO> update(@RequestBody @Valid MovieDTO movieDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.update(movieDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        movieService.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted!!");
    }
}
