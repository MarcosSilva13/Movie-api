package com.movie.movieapi.service;

import com.movie.movieapi.dtos.CategoryDTO;
import com.movie.movieapi.entity.Category;
import com.movie.movieapi.repository.CategoryRepository;
import com.movie.movieapi.service.exceptions.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryDTO> findAll() {

        return categoryRepository.findAll()
                .stream()
                .map(category -> new CategoryDTO(category))
                .collect(Collectors.toList());
    }

    public CategoryDTO findById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ID: " + id + " not found!"));

        return new CategoryDTO(category);
    }

    @Transactional
    public CategoryDTO insert(CategoryDTO categoryDTO) {
        Category category = new Category();
//        category.setName(categoryDTO.getName());

        BeanUtils.copyProperties(categoryDTO, category);

        category = categoryRepository.save(category);

        return new CategoryDTO(category);
    }

    public CategoryDTO update(CategoryDTO categoryDTO) {
        if (categoryDTO.getId() == null || categoryDTO.getId() <= 0) {
            throw new IllegalArgumentException("ID cannot be null or negative!");
        }

        Category category = categoryRepository.findById(categoryDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("ID: " + categoryDTO.getId() + " not found!"));

        BeanUtils.copyProperties(categoryDTO, category);

        category = categoryRepository.save(category);

        return new CategoryDTO(category);
    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ID: " + id + " not found!")).getId());
    }
}
