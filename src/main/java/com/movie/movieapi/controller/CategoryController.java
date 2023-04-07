package com.movie.movieapi.controller;

import com.movie.movieapi.dtos.CategoryDTO;
import com.movie.movieapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.findById(id));
    }

    @PostMapping(value = "/save")
    public ResponseEntity<CategoryDTO> insert(@RequestBody @Valid CategoryDTO categoryDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.insert(categoryDTO));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<CategoryDTO> update(@RequestBody @Valid CategoryDTO categoryDTO) {

        return ResponseEntity.status(HttpStatus.OK).body(categoryService.update(categoryDTO));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        categoryService.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted!!");
    }
}
