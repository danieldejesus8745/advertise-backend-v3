package com.advertise.adapters.outbound;

import com.advertise.application.domain.Token;
import com.advertise.application.ports.outbound.TokenOutboundPort;
import com.advertise.entities.TokenEntity;
import com.advertise.mappers.TokenMapper;
import com.advertise.repositories.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenOutboundAdapter implements TokenOutboundPort {

    private final TokenRepository tokenRepository;
    private final TokenMapper tokenMapper;

    @Override
    public Token addToken(Token token) {
        TokenEntity tokenEntity = tokenRepository.save(tokenMapper.toTokenEntity(token));
        return tokenMapper.toToken(tokenEntity);
    }

}
