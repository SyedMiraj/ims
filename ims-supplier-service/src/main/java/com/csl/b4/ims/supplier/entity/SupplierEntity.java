package com.csl.b4.ims.supplier.entity;

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
public class SupplierEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SUPPLIER_ID_GEN")
    @SequenceGenerator(
            name = "SUPPLIER_ID_GEN",
            allocationSize = 1,
            sequenceName = "S_SUPPLIER_ENTITY")
    private long id;
    private String code;
    private String fullName;
    private String address;
    private String phone;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
