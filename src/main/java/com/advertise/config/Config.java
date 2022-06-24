package com.advertise.config;

import com.advertise.application.ports.outbound.UserServicePort;
import com.advertise.application.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class Config {

    private final UserServicePort userServicePort;

    @Bean
    public UserService userService() {
        return new UserService(userServicePort);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new Argon2PasswordEncoder();
    }

}
