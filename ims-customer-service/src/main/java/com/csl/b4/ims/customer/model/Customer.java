package com.csl.b4.ims.customer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private long id;
    private String name;
    private String address;
    private String phone;
    private LocalDate createdAt;
    private LocalDate updatedAt;

}
