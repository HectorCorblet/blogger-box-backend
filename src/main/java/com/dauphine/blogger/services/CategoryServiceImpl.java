package com.dauphine.blogger.services;

import com.dauphine.blogger.Repository.CategoryRepository;
import com.dauphine.blogger.dto.CategoryDto;
import org.springframework.stereotype.Service;
import com.dauphine.blogger.models.Category;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getById(UUID id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category create(CategoryDto categoryDto) {
        final boolean alreadyExisting=categoryRepository.existsByName(categoryDto.getName());
        if(alreadyExisting){
            throw new RuntimeException("Category with name : " +categoryDto.getName() + " is already existing");
        }
        Category category=new Category();
        category.setId(UUID.randomUUID());
        category.setName(categoryDto.getName());
        return categoryRepository.save(category);

    }

    @Override
    public Category update(UUID id, CategoryDto categoryDto) {
        Category category=getById(id);
        if(category==null){
            return null;
        }
        category.setName(categoryDto.getName());
        return categoryRepository.save(category);
    }

    @Override
    public boolean deleteCategory(UUID id) {
        categoryRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Category> getAllByName(String name) {
        return categoryRepository.findAllByName(name);
    }
}
