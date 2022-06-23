package com.advertise.adapters.inbound;

import com.advertise.application.domain.User;
import com.advertise.application.ports.inbound.UserServicePort;
import com.advertise.application.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceAdapterInbound implements UserServicePort {

    private final UserService userService;

    @Override
    public void addUser(User user) {
        userService.addUser(user);
    }

}
