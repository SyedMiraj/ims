package com.csl.b4.ims.product.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "CATEGORY_ID_GEN")
    @SequenceGenerator(
            name = "CATEGORY_ID_GEN",
            allocationSize = 1,
            sequenceName = "S_CATEGORY_ENTITY")
    private long id;

    private Long parentId;

    private String title;

    private String description;

    @OneToMany(mappedBy="category")
    private Set<ProductEntity> products;
}
