package com.advertise.application.ports.inbound;

import com.advertise.application.domain.Token;

import java.util.UUID;

public interface TokenInboundPort {

    Token createToken(UUID owner);

    String addToken(Token token);

}
