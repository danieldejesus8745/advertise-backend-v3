package com.advertise.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@Entity(name = "tokens")
public class TokenEntity {

    @Id
    @GeneratedValue
    private UUID uuid;

    @Column(nullable = false)
    private long expiration;

    @Column(nullable = false)
    private UUID owner;

    @Column(nullable = false)
    private LocalDate createdAt;

}
