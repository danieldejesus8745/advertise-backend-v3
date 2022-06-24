package com.advertise.application.ports.inbound;

import com.advertise.application.domain.User;

public interface UserServicePort {

    void addUser(User user);

    String login(String email, String password);

}
