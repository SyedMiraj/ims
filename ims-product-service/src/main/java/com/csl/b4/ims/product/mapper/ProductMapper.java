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

    public ProductMapper(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public ProductEntity toEntity(Product dto){
        ProductEntity entity = productRepository.findById(dto.getId())
                .orElse(new ProductEntity());
        entity.setTitle(dto.getTitle());
        entity.setCategory(categoryRepository.findById(dto.getCategoryId()).orElseThrow( () -> new RuntimeException("Category not found")));
        entity.setDescription(dto.getDescription());
        entity.setPurchasePrice(dto.getPurchasePrice());
        entity.setSellingPrice(dto.getSellingPrice());
        // availableQuantity will be updated by purchase and sell
        return entity;
    }

    public Product toDto(ProductEntity entity){
        Product dto = new Product();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setCategoryId(entity.getCategory().getId());
        dto.setPurchasePrice(entity.getPurchasePrice());
        dto.setSellingPrice(entity.getSellingPrice());
        dto.setAvailableQuantity(entity.getAvailableQuantity());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }
}
