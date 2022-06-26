package com.advertise.application.ports.outbound;

import com.advertise.application.domain.Token;

public interface TokenOutboundPort {

    Token addToken(Token token);

}
