package com.csl.b4.ims.product.repository;

import com.csl.b4.ims.product.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
