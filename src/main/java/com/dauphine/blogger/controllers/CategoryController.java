package com.dauphine.blogger.controllers;

import com.dauphine.blogger.dto.CategoryDto;
import com.dauphine.blogger.services.CategoryService;
import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.services.exceptions.CategoryNotFoundByIdException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController (CategoryService categoryService){
        this.categoryService=categoryService;
    }
    @GetMapping("")
    public ResponseEntity<List<Category>> getAllCategories(@RequestParam(required = false) String name) {
        List<Category> categories = name==null || name.isBlank()
                ? categoryService.getAllCategories()
                : categoryService.getAllByName(name);
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<Category> getACategory(@PathVariable UUID categoryId) throws CategoryNotFoundByIdException {
        final Category category = categoryService.getById(categoryId);
        return ResponseEntity.ok(category);
    }


    @PostMapping("")
    public Category createCategory(@RequestBody CategoryDto category) {
        return categoryService.create(category);

    }


    @PutMapping("/{categoryId}")
    public void updateCategory(@PathVariable("categoryId") UUID categoryId,
                               @RequestBody CategoryDto category) throws CategoryNotFoundByIdException {
        categoryService.update(categoryId,category);
    }

    @DeleteMapping("/{categoryId}")
    public boolean deleteCategory(@PathVariable UUID categoryId) throws CategoryNotFoundByIdException {
        return categoryService.deleteCategory(categoryId);
    }
}