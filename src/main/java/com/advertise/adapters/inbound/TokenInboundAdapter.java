package com.advertise.adapters.inbound;

import com.advertise.application.domain.Token;
import com.advertise.application.ports.inbound.TokenInboundPort;
import com.advertise.application.services.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TokenInboundAdapter implements TokenInboundPort {

    private final TokenService tokenService;

    @Override
    public Token createToken(UUID owner) {
        return tokenService.createToken(owner);
    }

    @Override
    public String addToken(Token token) {
        return tokenService.addToken(token);
    }

}
