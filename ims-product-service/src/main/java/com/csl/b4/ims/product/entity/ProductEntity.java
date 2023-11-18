package com.csl.b4.ims.product.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "PRODUCT_ID_GEN")
    @SequenceGenerator(
            name = "PRODUCT_ID_GEN",
            allocationSize = 1,
            sequenceName = "S_PRODUCT_ENTITY")
    private long id;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID")
    private CategoryEntity category;

    private String description;

    @Column(name = "QUANTITY")
    private double availableQuantity;

    private LocalDate createdAt;

    private LocalDate updatedAt;
}
