package com.csl.b4.ims.product.repository;

import com.csl.b4.ims.product.entity.PurchaseOrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PurchaseOrderDetailsRepository extends JpaRepository<PurchaseOrderDetailsEntity, Long>, JpaSpecificationExecutor {
}
