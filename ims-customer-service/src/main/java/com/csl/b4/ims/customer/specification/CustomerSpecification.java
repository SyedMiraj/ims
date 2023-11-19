package com.csl.b4.ims.customer.specification;

import com.csl.b4.ims.customer.entity.CustomerEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;

public class CustomerSpecification {
    public static Specification<CustomerEntity> findSCustomers(String name, String address, String phone){
        return (root, query, cb) -> {
            Predicate predicate = cb.conjunction();
            if (name != null) {
                predicate = cb.and(predicate, cb.like(root.get("name"), "%" + name + "%"));
            }
            if (address != null) {
                predicate = cb.and(predicate, cb.like(root.get("address"), "%" + address + "%"));
            }
            if (phone != null) {
                predicate = cb.and(predicate, cb.like(root.get("phone"), "%" + phone + "%"));
            }
            predicate.in(query.orderBy(cb.desc(root.get("id"))));
            return predicate;
        };
    }
}
