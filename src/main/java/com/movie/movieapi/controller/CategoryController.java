package com.movie.movieapi.controller;

import com.movie.movieapi.dtos.CategoryRequestDTO;
import com.movie.movieapi.dtos.CategoryResponseDTO;
import com.movie.movieapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.findById(id));
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> insert(@RequestBody @Valid CategoryRequestDTO categoryRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.insert(categoryRequestDTO));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoryResponseDTO> update(@PathVariable Long id,
                                                      @RequestBody @Valid CategoryRequestDTO categoryRequestDTO) {

        return ResponseEntity.status(HttpStatus.OK).body(categoryService.update(id, categoryRequestDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        categoryService.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted!!");
    }
}
