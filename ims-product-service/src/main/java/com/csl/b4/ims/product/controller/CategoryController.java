package com.csl.b4.ims.product.controller;

import com.csl.b4.ims.product.model.Category;
import com.csl.b4.ims.product.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<Void> saveCategory(@RequestBody Category category){
        categoryService.saveCategory(category);
        return ResponseEntity.accepted().build();
    }
}
