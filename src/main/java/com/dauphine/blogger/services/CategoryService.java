package com.dauphine.blogger.services;

import com.dauphine.blogger.models.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    List<Category> getAllCategories();

    Category getById(UUID id);

    Category createNewCategory(String name);

    Category updateCategoryName( UUID id, String name);

    boolean deleteCategory(UUID id);

    List<Category> getAllByName(String name);
}
