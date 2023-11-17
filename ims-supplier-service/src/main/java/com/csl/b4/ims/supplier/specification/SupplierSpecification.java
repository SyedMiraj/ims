package com.csl.b4.ims.supplier.specification;

import com.csl.b4.ims.supplier.entity.SupplierEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;

public class SupplierSpecification {

    public static Specification<SupplierEntity> findSuppliers(String code, String name, String phone){
        return (root, query, cb) -> {
            Predicate predicate = cb.conjunction();
            if (code != null) {
                predicate = cb.and(predicate, cb.equal(root.get("code"), code));
            }
            if (name != null) {
                predicate = cb.and(predicate, cb.like(root.get("fullName"), "%" + name + "%"));
            }
            if (phone != null) {
                predicate = cb.and(predicate, cb.like(root.get("phone"), "%" + phone + "%"));
            }
            predicate.in(query.orderBy(cb.desc(root.get("id"))));
            return predicate;
        };
    }
}
