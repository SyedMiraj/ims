package com.csl.b4.ims.user.model;

public enum Roles {
    ADMIN("administrator"),
    EMPLOYEE("employee");

    private String name;

    Roles(String name) {
        this.name = name;
    }
}
