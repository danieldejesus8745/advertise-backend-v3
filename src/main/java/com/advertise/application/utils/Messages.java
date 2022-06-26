package com.advertise.application.utils;

public enum Messages {

    USER_NOT_FOUND("Usuário não encontrado"),
    INVALID_CREDENTIALS("Credenciais inválidas"),
    EMAIL_ALREADY_REGISTERED("Esse e-mail já está cadastrado");

    private final String description;

    Messages(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
