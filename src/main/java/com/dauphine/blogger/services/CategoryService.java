package com.dauphine.blogger.services;

import com.dauphine.blogger.dto.CategoryDto;
import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.services.exceptions.CategoryNotFoundByIdException;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    List<Category> getAllCategories();

    Category getById(UUID id) throws CategoryNotFoundByIdException;

    Category create(CategoryDto category);

    Category update(UUID id,CategoryDto category)throws CategoryNotFoundByIdException;
    boolean deleteCategory(UUID id)throws CategoryNotFoundByIdException;

    List<Category> getAllByName(String name);
}
