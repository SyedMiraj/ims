package com.csl.b4.ims.supplier.controller;

import com.csl.b4.ims.supplier.model.Supplier;
import com.csl.b4.ims.supplier.service.SupplierService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping
    public ResponseEntity<Void> saveSupplier(@RequestBody Supplier supplier){
        supplierService.saveSupplier(supplier);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<?> getSuppliers(@RequestParam(name = "asPage", required = false, defaultValue = "false") Boolean asPage,
                                          @RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "3") int size,
                                          @RequestParam(name = "code", required = false) String code,
                                          @RequestParam(name = "name", required = false) String name,
                                          @RequestParam(name = "phone", required = false) String phone){
        if(asPage){
            Pageable pageable = PageRequest.of(page, size);
            Page<Supplier> suppliersAsPage = supplierService.findAllSuppliers(pageable, code, name, phone);
            return ResponseEntity.ok(suppliersAsPage);
        }
        List<Supplier> suppliersAsList = supplierService.findAllSuppliers(code, name, phone);
        return ResponseEntity.ok(suppliersAsList);
    }
    @GetMapping("/{id}/exist")
    public ResponseEntity<Boolean> isExist(@PathVariable("id") Long id){
        boolean exist = supplierService.isExist(id);
        return exist ? ResponseEntity.ok(exist) : ResponseEntity.notFound().build();
    }
}
