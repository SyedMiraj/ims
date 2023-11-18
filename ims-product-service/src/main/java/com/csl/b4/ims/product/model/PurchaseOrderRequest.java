package com.csl.b4.ims.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrderRequest {
    private Long orderRequestId;
    private String orderNumber;
    private Long supplierId;
    private Set<ProductWiseQuantity> productWiseQuantitySet;
    private LocalDate orderDate;
    private BigDecimal paidAmount;
    private BigDecimal dueAmount;
    private String entryUsername;
}
