package com.csl.b4.ims.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private long id;
    private Long parentId;
    private String title;
    private String description;
    private Set<Product> products;
}
