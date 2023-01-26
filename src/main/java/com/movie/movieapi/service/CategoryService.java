package com.movie.movieapi.service;

import com.movie.movieapi.entity.Category;
import com.movie.movieapi.entity.Movie;
import com.movie.movieapi.repository.CategoryRepository;
import com.movie.movieapi.service.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ID: " + id + " não encontrado!"));
    }

    public Category insert(Category category) {
        return categoryRepository.save(category);
    }

    public Category update(Long id, String name, List<Movie> movies) {
        Category cat = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ID: " + id + " não encontrado!"));

        cat.setName(name);
        cat.getMovies().addAll(movies);

        return categoryRepository.save(cat);
    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ID: " + id + " não encontrado!")).getId());
    }
}
