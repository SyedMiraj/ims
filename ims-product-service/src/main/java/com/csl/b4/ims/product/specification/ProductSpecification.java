package com.csl.b4.ims.product.specification;

import com.csl.b4.ims.product.entity.ProductEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;

public class ProductSpecification {

    public static Specification<ProductEntity> findProducts(String title, Long categoryId){
        return (root, query, cb) -> {
            Predicate predicate = cb.conjunction();
            if (title != null) {
                predicate = cb.and(predicate, cb.like(root.get("title"), "%" + title + "%"));
            }
            if(categoryId != null){
                predicate = cb.and(predicate, cb.equal(root.get("category").get("id"), categoryId));
            }
            predicate.in(query.orderBy(cb.desc(root.get("id"))));
            return predicate;
        };
    }
}
