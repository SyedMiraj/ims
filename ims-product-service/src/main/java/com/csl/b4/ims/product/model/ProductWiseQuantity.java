package com.csl.b4.ims.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductWiseQuantity {
    private Long productId;
    private double quantity;
    private BigDecimal rate;
}
