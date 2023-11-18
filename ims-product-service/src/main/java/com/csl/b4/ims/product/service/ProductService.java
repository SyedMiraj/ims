package com.csl.b4.ims.product.service;

import com.csl.b4.ims.product.entity.ProductEntity;
import com.csl.b4.ims.product.mapper.ProductMapper;
import com.csl.b4.ims.product.model.InventoryActivity;
import com.csl.b4.ims.product.model.Product;
import com.csl.b4.ims.product.repository.ProductRepository;
import com.csl.b4.ims.product.specification.ProductSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDate;
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
        List<ProductEntity> products = productRepository.findAll(ProductSpecification.findProducts(title, categoryId));
        return products.stream().map(productMapper::toDto).collect(Collectors.toList());
    }

    public Page<Product> findAllProducts(Pageable pageable, String title, Long categoryId){
        Page<ProductEntity> products = productRepository.findAll(ProductSpecification.findProducts(title, categoryId), pageable);
        return products.map(productMapper::toDto);
    }

    public void saveProduct(Product product){
        ProductEntity entity = productMapper.toEntity(product);
        entity.setCreatedAt(LocalDate.now());
        productRepository.save(entity);
    }

    public void updateProductStock(Long productId, double quantity, InventoryActivity activity) {
        ProductEntity entity = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id " + productId));
        double currentStock = entity.getAvailableQuantity();
        if(activity.equals(InventoryActivity.Purchase)){
            currentStock += quantity;
        } else {
            currentStock -= quantity;
        }
        entity.setAvailableQuantity(currentStock);
    }
}
