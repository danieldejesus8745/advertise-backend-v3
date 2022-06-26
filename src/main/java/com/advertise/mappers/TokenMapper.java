package com.advertise.mappers;

import com.advertise.application.domain.Token;
import com.advertise.entities.TokenEntity;
import org.springframework.stereotype.Service;

@Service
public class TokenMapper {

    public TokenEntity toTokenEntity(Token token) {
        TokenEntity tokenEntity = new TokenEntity();
        tokenEntity.setUuid(token.getUuid());
        tokenEntity.setExpiration(token.getExpiration());
        tokenEntity.setOwner(token.getOwner());
        tokenEntity.setCreatedAt(token.getCreatedAt());
        return tokenEntity;
    }

    public Token toToken(TokenEntity tokenEntity) {
        Token token = new Token();
        token.setUuid(tokenEntity.getUuid());
        token.setExpiration(tokenEntity.getExpiration());
        token.setOwner(tokenEntity.getOwner());
        token.setCreatedAt(tokenEntity.getCreatedAt());
        return token;
    }

}
