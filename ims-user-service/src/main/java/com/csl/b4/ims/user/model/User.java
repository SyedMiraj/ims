package com.csl.b4.ims.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private long id;
    private String username;
    private String fullName;
    private String phone;
    private String password;
    private String confirmPassword;
    private Roles role;
}
