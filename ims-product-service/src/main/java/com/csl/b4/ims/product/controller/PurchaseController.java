package com.csl.b4.ims.product.controller;

import com.csl.b4.ims.product.model.PurchaseOrderRequest;
import com.csl.b4.ims.product.service.PurchaseService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products/purchases")
public class PurchaseController {

    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping
    @Operation(description = "Purchase products from supplier")
    public ResponseEntity<Void> purchaseProducts(@RequestBody PurchaseOrderRequest purchaseOrderRequest){
        purchaseService.saveOrder(purchaseOrderRequest);
        return ResponseEntity.accepted().build();
    }
}
