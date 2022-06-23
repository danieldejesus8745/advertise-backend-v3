package com.advertise.application.services;

import com.advertise.application.domain.User;
import com.advertise.application.ports.outbound.UserServicePort;

import java.time.LocalDate;

public class UserService {

    private final UserServicePort userServicePort;

    public UserService(UserServicePort userServicePort) {
        this.userServicePort = userServicePort;
    }

    public void addUser(User user) {
        user.setCreatedAt(LocalDate.now());
        userServicePort.addUser(user);
    }

}
