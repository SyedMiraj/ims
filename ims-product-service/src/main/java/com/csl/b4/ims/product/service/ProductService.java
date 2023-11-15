package com.csl.b4.ims.product.service;

import com.csl.b4.ims.product.entity.ProductEntity;
import com.csl.b4.ims.product.mapper.ProductMapper;
import com.csl.b4.ims.product.model.Product;
import com.csl.b4.ims.product.repository.ProductRepository;
import com.csl.b4.ims.product.specification.ProductSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final CategoryService categoryService;
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(CategoryService categoryService, ProductRepository productRepository, ProductMapper productMapper) {
        this.categoryService = categoryService;
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public List<Product> findAllProducts(String title, Long categoryId){
        List<Entity> products = productRepository.findAll(ProductSpecification.findProducts(title, categoryId));
        return null;
    }

    public Page<Product> findAllProducts(Pageable pageable, String title, Long categoryId){
        Page<ProductEntity> products = productRepository.findAll(ProductSpecification.findProducts(title, categoryId), pageable);
//        products.get()
//                .map(entity -> productMapper.toDto(entity))
//                .;
        return null;
    }
}
