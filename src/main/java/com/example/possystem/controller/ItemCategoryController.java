package com.example.possystem.controller;


import com.example.possystem.entitiy.ItemCategory;
import com.example.possystem.service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/categories")
@CrossOrigin
public class ItemCategoryController {

    @Autowired
    private ItemCategoryService categoryService;

    // Create Category
    @PostMapping
    public ResponseEntity<ItemCategory> createCategory(@RequestBody ItemCategory category) {
        ItemCategory newCategory = categoryService.addCategory(category);
        return ResponseEntity.ok(newCategory);
    }

    // Get All Categories
    @GetMapping
    public ResponseEntity<List<ItemCategory>> getAllCategories() {
        List<ItemCategory> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    // Get Category by ID
    @GetMapping("/{id}")
    public ResponseEntity<ItemCategory> getCategoryById(@PathVariable Long id) {
        ItemCategory category = categoryService.getCategoryById(id);
        return ResponseEntity.ok(category);
    }

    // Update Category
    @PutMapping("/{id}")
    public ResponseEntity<ItemCategory> updateCategory(@PathVariable Long id, @RequestBody ItemCategory category) {
        ItemCategory updatedCategory = categoryService.updateCategory(id, category);
        return ResponseEntity.ok(updatedCategory);
    }

    // Delete Category
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
