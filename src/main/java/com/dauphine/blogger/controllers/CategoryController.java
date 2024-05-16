package com.dauphine.blogger.controllers;

import com.dauphine.blogger.services.CategoryService;
import com.dauphine.blogger.models.Category;
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
    @GetMapping("/")
    public List<Category> getAllCategories(@RequestParam String name) {
        return name==null || name.isBlank()
                ? categoryService.getAllCategories()
                : categoryService.getAllByName(name);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getACategory(@PathVariable UUID id) {
        final Category category = categoryService.getById(id);
        return ResponseEntity.ok(category);
    }


//    @PostMapping("/")
//    public ResponseEntity<Category> createNewCategory(@RequestBody CategoryRequest request) {
//        final Category category = categoryService.createNewCategory(request.getname());
//        return categoryService.createNewCategory(request);
//    }

    @PutMapping("/{id}")
    public Category updateCategoryName(@PathVariable UUID id, @RequestBody String name) {
        return categoryService.updateCategoryName(id,name);
    }

    @DeleteMapping("/{id}")
    public boolean deleteCategory(@PathVariable UUID id) {
        return categoryService.deleteCategory(id);
    }
}