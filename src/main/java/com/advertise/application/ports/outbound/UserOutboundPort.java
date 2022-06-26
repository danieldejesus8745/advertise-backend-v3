package com.advertise.application.ports.outbound;

import com.advertise.application.domain.User;

public interface UserOutboundPort {

    void addUser(User user);

    User login(String email);

}
