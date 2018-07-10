package com.github.project.model;

public enum RoleEnum {
    NOT_VERIFIED("NOT_VERIFIED"),
    VERIFIED("VERIFIED"),
    ADMIN("ADMIN");

    private String name;

    RoleEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
