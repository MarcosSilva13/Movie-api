package com.movie.movieapi.util;

import com.movie.movieapi.dtos.CategoryRequestDTO;
import com.movie.movieapi.entity.Category;

public class CategoryConverter {

    public static void convertDtoToEntity(CategoryRequestDTO dto, Category category) {
        category.setName(dto.getName());
    }
}
