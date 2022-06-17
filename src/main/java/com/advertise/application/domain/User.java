package com.advertise.application.domain;

import java.time.LocalDate;
import java.util.UUID;

public class User {

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

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

}
