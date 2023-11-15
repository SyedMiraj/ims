package com.csl.b4.ims.product.service;

import com.csl.b4.ims.product.entity.CategoryEntity;
import com.csl.b4.ims.product.mapper.CategoryMapper;
import com.csl.b4.ims.product.model.Category;
import com.csl.b4.ims.product.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public void saveCategory(Category category){
        CategoryEntity entity = categoryMapper.toEntity(category);
        categoryRepository.save(entity);
    }
}
