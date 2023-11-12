package com.csl.b4.ims.user.entity;

import com.csl.b4.ims.user.model.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "USER_ID_GEN")
    @SequenceGenerator(
            name = "USER_ID_GEN",
            allocationSize = 1,
            sequenceName = "S_USER_ENTITY")
    private long id;
    private String fullName;
    private String phone;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Roles role;
}
