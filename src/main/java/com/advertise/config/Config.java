package com.advertise.config;

import com.advertise.application.ports.outbound.UserServicePort;
import com.advertise.application.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class Config {

    private final UserServicePort userServicePort;

    @Bean
    public UserService userService() {
        return new UserService(userServicePort);
    }

}
