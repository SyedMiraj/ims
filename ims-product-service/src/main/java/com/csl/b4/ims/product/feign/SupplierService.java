package com.csl.b4.ims.product.feign;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {

    private final SupplierFeign supplierFeign;

    public SupplierService(SupplierFeign supplierFeign) {
        this.supplierFeign = supplierFeign;
    }

    public boolean isExist(Long id){
        ResponseEntity<Boolean> response = supplierFeign.isExist(id);
        if(response.getStatusCode().is2xxSuccessful()) {
            Boolean isExist = response.getBody();
            return Boolean.TRUE.equals(isExist);
        }
        return false;
    }
}
