package com.advertise.dto;

import java.time.LocalDate;
import java.util.UUID;

public class UserDTO {

    private UUID uuid;
    private String name;
    private String email;
    private String password;
    private LocalDate createdAt;

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
