package com.csl.b4.ims.product.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "ORDER_DETAILS_ENTITY")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrderDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ORDER_DETAILS_ID_GEN")
    @SequenceGenerator(
            name = "ORDER_DETAILS_ID_GEN",
            allocationSize = 1,
            sequenceName = "S_ORDER_DETAILS_ENTITY")
    private long id;
    private Long productId;
    private BigDecimal rate;
    private double quantity;
    private BigDecimal amount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id", nullable=false)
    private PurchaseOrderEntity order;
}
