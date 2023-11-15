package com.csl.b4.ims.product.mapper;

import com.csl.b4.ims.product.entity.ProductEntity;
import com.csl.b4.ims.product.model.Product;
import com.csl.b4.ims.product.repository.CategoryRepository;
import com.csl.b4.ims.product.repository.ProductRepository;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public ProductMapper(ProductRepository productRepository, CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public ProductEntity toEntity(Product dto){
        ProductEntity entity = productRepository.findById(dto.getId())
                .orElse(new ProductEntity());
        entity.setTitle(dto.getTitle());
        entity.setCategory(categoryRepository.findById(dto.getCategory().getId()).orElseThrow( () -> new RuntimeException("Category not found")));
        entity.setDescription(dto.getDescription());
        return entity;
    }

    public Product toDto(ProductEntity entity){
        Product dto = new Product();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setCategory(categoryMapper.toDto(entity.getCategory()));
        return dto;
    }
}
