package com.dauphine.blogger.controllers;

import jdk.jfr.Category;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {

    @GetMapping("/")
    public List<Category> getAllCategories() {
        return null;
    }

    @GetMapping("/{id}")
    public Category getACategory(@PathVariable int id) {
        return null;
    }

    @PostMapping("/")
    public String createNewCategory(@RequestBody) {
        return "";
    }

    @PostMapping("/")
    public String createNewCategory(@RequestBody Category category) {
        return "";
    }

    @PutMapping("/{id}")
    public String updateCategoryName(@PathVariable int id, @RequestBody Category category) {
        return "";
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable int id) {
        return "";

    }
}