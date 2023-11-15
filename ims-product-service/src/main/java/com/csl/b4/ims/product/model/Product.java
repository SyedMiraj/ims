package com.csl.b4.ims.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private long id;
    private String title;
    private Long categoryId;
    private String description;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
