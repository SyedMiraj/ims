package com.csl.b4.ims.product.mapper;

import com.csl.b4.ims.product.entity.CategoryEntity;
import com.csl.b4.ims.product.model.Category;
import com.csl.b4.ims.product.repository.CategoryRepository;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    private final CategoryRepository categoryRepository;

    public CategoryMapper(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryEntity toEntity(Category dto){
        CategoryEntity entity = categoryRepository.findById(dto.getId())
                .orElse(new CategoryEntity());
        entity.setTitle(dto.getTitle());
        entity.setParentId(dto.getParentId());
        entity.setDescription(dto.getDescription());
        return entity;
    }

    public Category toDto(CategoryEntity entity){
        Category dto = new Category();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setParentId(entity.getParentId());
        dto.setDescription(entity.getDescription());
        return dto;
    }
}
