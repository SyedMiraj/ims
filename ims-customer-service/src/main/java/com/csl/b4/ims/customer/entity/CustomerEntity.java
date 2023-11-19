package com.csl.b4.ims.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "CUSTOMER_ID_GEN")
    @SequenceGenerator(
            name = "CUSTOMER_ID_GEN",
            allocationSize = 1,
            sequenceName = "S_CUSTOMER_ENTITY")
    private long id;
    private String name;
    private String address;
    private String phone;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
