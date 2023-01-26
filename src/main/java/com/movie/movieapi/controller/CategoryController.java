package com.movie.movieapi.controller;

import com.movie.movieapi.entity.Category;
import com.movie.movieapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> categories = categoryService.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Category category = categoryService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(category);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Category> insert(@RequestBody Category category) {
        Category categorySaved = categoryService.insert(category);

        return ResponseEntity.status(HttpStatus.CREATED).body(categorySaved);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Category> update(@RequestBody Category category) {
        Category categoryUpdated = categoryService.update(category.getId(),
                category.getName(), category.getMovies());

        return ResponseEntity.status(HttpStatus.OK).body(categoryUpdated);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        categoryService.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
    }
}
