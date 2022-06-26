package com.advertise.application.services;

import com.advertise.application.domain.User;
import com.advertise.application.ports.outbound.UserOutboundPort;

import java.time.LocalDate;

public class UserService {

    private final UserOutboundPort userOutboundPort;

    public UserService(UserOutboundPort userOutboundPort) {
        this.userOutboundPort = userOutboundPort;
    }

    public void addUser(User user) {
        user.setCreatedAt(LocalDate.now());
        userOutboundPort.addUser(user);
    }

    public User login(String email) {
        return userOutboundPort.login(email);
    }

}
