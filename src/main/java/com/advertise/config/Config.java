package com.advertise.config;

import com.advertise.application.ports.outbound.TokenOutboundPort;
import com.advertise.application.ports.outbound.UserOutboundPort;
import com.advertise.application.services.TokenService;
import com.advertise.application.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class Config {

    private final UserOutboundPort userOutboundPort;
    private final TokenOutboundPort tokenOutboundPort;

    @Bean
    public UserService userService() {
        return new UserService(userOutboundPort);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new Argon2PasswordEncoder();
    }

    @Bean
    public TokenService tokenService() {
        return new TokenService(tokenOutboundPort);
    }

}
