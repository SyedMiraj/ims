package com.csl.b4.ims.supplier.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {
    private long id;
    private String code;
    private String fullName;
    private String address;
    private String phone;
    private LocalDate createdAt;
    private LocalDate updatedAt;

}
