package com.advertise.application.services;

import com.advertise.application.domain.Token;
import com.advertise.application.ports.outbound.TokenOutboundPort;

import java.time.LocalDate;
import java.util.UUID;

public class TokenService {

    private final TokenOutboundPort tokenOutboundPort;

    public TokenService(TokenOutboundPort tokenOutboundPort) {
        this.tokenOutboundPort = tokenOutboundPort;
    }

    public Token createToken(UUID owner) {
        Token token = new Token();
        token.setExpiration(System.currentTimeMillis() + 120000);
        token.setOwner(owner);
        token.setCreatedAt(LocalDate.now());
        return token;
    }

    public String addToken(Token token) {
        Token tokenAdded = tokenOutboundPort.addToken(token);
        return tokenAdded.getUuid().toString();
    }

}
