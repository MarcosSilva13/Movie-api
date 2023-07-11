package com.movie.movieapi.controller;

import com.movie.movieapi.dtos.MovieRequestDTO;
import com.movie.movieapi.dtos.MovieResponseDTO;
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
    public ResponseEntity<List<MovieResponseDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.findAll());
    }

    @GetMapping(value = "/sortByName")
    public ResponseEntity<List<MovieResponseDTO>> findOrderByName() {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.findOrderByName());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MovieResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.findById(id));
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<List<MovieResponseDTO>> findByName(@PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.findByName(name));
    }

    @PostMapping
    public ResponseEntity<MovieResponseDTO> insert(@RequestBody @Valid MovieRequestDTO movieRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.insert(movieRequestDTO));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MovieResponseDTO> update(@PathVariable Long id, @RequestBody @Valid MovieRequestDTO movieRequestDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.update(id, movieRequestDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        movieService.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted!!");
    }
}
