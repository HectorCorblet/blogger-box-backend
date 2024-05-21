package com.dauphine.blogger.services;

import com.dauphine.blogger.dto.CategoryDto;
import com.dauphine.blogger.models.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    List<Category> getAllCategories();

    Category getById(UUID id);

    Category create(CategoryDto category);

    Category update(UUID id,CategoryDto category);
    boolean deleteCategory(UUID id);

    List<Category> getAllByName(String name);
}
