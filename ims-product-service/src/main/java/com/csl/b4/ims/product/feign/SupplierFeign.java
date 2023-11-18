package com.csl.b4.ims.product.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "IMS-SUPPLIER-SERVICE")
public interface SupplierFeign {

    @GetMapping("suppliers/{id}/exist")
    public ResponseEntity<Boolean> isExist(@PathVariable("id") Long id);
}
