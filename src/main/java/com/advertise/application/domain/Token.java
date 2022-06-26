package com.advertise.application.domain;

import java.time.LocalDate;
import java.util.UUID;

public class Token {

    private UUID uuid;
    private long expiration;
    private UUID owner;
    private LocalDate createdAt;

    public UUID getUuid() {
        return uuid;
    }

    public long getExpiration() {
        return expiration;
    }

    public UUID getOwner() {
        return owner;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setExpiration(long expiration) {
        this.expiration = expiration;
    }

    public void setOwner(UUID owner) {
        this.owner = owner;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

}
