package com.advertise.application.domain;

import com.advertise.application.dto.UserDTO;

import java.time.LocalDate;
import java.util.UUID;

public class User {

    private UUID uuid;
    private final String name;
    private final String email;
    private final String password;
    private LocalDate createdAt;

    public User(UserDTO userDTO) {
        name = userDTO.getName();
        email = userDTO.getEmail();
        password = userDTO.getPassword();
    }

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

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

}
