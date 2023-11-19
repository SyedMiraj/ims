package com.csl.b4.ims.product.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "SELL_ENTITY")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellOrderEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SELL_ID_GEN")
    @SequenceGenerator(
            name = "SELL_ID_GEN",
            allocationSize = 1,
            sequenceName = "S_SELL_ENTITY")
    private long id;
    private String orderNumber;
    private Long customerId;
    private LocalDate orderDate;
    private BigDecimal paidAmount;
    private BigDecimal dueAmount;
    private String entryUsername;


}
