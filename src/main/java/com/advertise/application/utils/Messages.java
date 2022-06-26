package com.advertise.application.utils;

public enum Messages {

    USER_NOT_FOUND("Usuário não encontrado"),
    INVALID_CREDENTIALS("Credenciais inválidas");

    private final String description;

    Messages(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
