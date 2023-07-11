package com.movie.movieapi.service;

import com.movie.movieapi.dtos.CategoryRequestDTO;
import com.movie.movieapi.dtos.CategoryResponseDTO;
import com.movie.movieapi.entity.Category;
import com.movie.movieapi.repository.CategoryRepository;
import com.movie.movieapi.service.exceptions.EntityNotFoundException;
import com.movie.movieapi.util.CategoryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<CategoryResponseDTO> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CategoryResponseDTO findById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ID: " + id + " not found!"));

        return new CategoryResponseDTO(category);
    }

    @Transactional
    public CategoryResponseDTO insert(CategoryRequestDTO categoryRequestDTO) {
        Category category = new Category();

        CategoryConverter.convertDtoToEntity(categoryRequestDTO, category);

        return new CategoryResponseDTO(categoryRepository.save(category));
    }

    @Transactional
    public CategoryResponseDTO update(Long id, CategoryRequestDTO categoryRequestDTO) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ID: " + id + " not found!"));

        CategoryConverter.convertDtoToEntity(categoryRequestDTO, category);

        return new CategoryResponseDTO(categoryRepository.save(category));
    }

    @Transactional
    public void deleteById(Long id) {
        categoryRepository.deleteById(categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ID: " + id + " not found!")).getId());
    }
}
