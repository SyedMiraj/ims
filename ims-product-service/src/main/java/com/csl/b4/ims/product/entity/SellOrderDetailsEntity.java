package com.csl.b4.ims.product.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity(name = "SELL_DETAILS_ENTITY")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellOrderDetailsEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SELL_DETAILS_ID_GEN")
    @SequenceGenerator(
            name = "SELL_DETAILS_ID_GEN",
            allocationSize = 1,
            sequenceName = "S_SELL_DETAILS_ENTITY")
    private long id;
    private Long productId;
    private BigDecimal rate;
    private double quantity;
    private BigDecimal amount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="sell_order_id", nullable=false)
    private SellOrderEntity sell;
}
