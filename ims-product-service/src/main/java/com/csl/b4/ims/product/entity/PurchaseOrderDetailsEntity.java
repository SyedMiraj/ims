package com.csl.b4.ims.product.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity(name = "PURCHASE_DETAILS_ENTITY")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrderDetailsEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "PURCHASE_DETAILS_ID_GEN")
    @SequenceGenerator(
            name = "PURCHASE_DETAILS_ID_GEN",
            allocationSize = 1,
            sequenceName = "S_PURCHASE_DETAILS_ENTITY")
    private long id;
    private Long productId;
    private BigDecimal rate;
    private double quantity;
    private BigDecimal amount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="purchase_order_id", nullable=false)
    private PurchaseOrderEntity purchase;
}
