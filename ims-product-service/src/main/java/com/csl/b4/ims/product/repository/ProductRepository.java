package com.csl.b4.ims.product.repository;

import com.csl.b4.ims.product.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>, JpaSpecificationExecutor {
}
