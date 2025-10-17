package com.poliemergencias.demo.dto;

public class UserDto {
    private String name;
    private String role;

    public UserDto() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public UserDto(String name, String role) {
        this.name = name;
        this.role = role;
    }
}
