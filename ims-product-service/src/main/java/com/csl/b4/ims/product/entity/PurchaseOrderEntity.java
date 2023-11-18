package com.csl.b4.ims.product.entity;

import com.csl.b4.ims.product.model.ProductWiseQuantity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "ORDER_ENTITY")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrderEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ORDER_ID_GEN")
    @SequenceGenerator(
            name = "ORDER_ID_GEN",
            allocationSize = 1,
            sequenceName = "S_ORDER_ENTITY")
    private long id;
    private String orderNumber;
    private Long supplierId;
    private LocalDate orderDate;
    private BigDecimal paidAmount;
    private BigDecimal dueAmount;
    private String entryUsername;
}
