package com.csl.b4.ims.product.controller;

import com.csl.b4.ims.product.model.Product;
import com.csl.b4.ims.product.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<?> getProducts(
            @RequestParam(name = "asPage", required = false, defaultValue = "false") Boolean asPage,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(name = "title", required = false) String title,
            @RequestParam(name = "categoryId", required = false) Long categoryId){
        if(asPage){
            Pageable pageable = PageRequest.of(page, size);
            Page<Product> productsAsPage = productService.findAllProducts(pageable, title, categoryId);
            return ResponseEntity.ok(productsAsPage);
        }
        List<Product> productsAsList = productService.findAllProducts(title, categoryId);
        return ResponseEntity.ok(productsAsList);
    }

    @PostMapping
    public ResponseEntity<Void> saveProduct(@RequestBody Product product){
        productService.saveProduct(product);
        return ResponseEntity.accepted().build();
    }
}
