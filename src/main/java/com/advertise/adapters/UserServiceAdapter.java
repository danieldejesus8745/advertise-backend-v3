package com.advertise.adapters;

import com.advertise.application.domain.User;
import com.advertise.application.ports.UserServicePort;
import com.advertise.entities.UserEntity;
import com.advertise.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
public class UserServiceAdapter implements UserServicePort {

    private final UserRepository userRepository;

    @Override
    public void addUser(User user) {
        user.setCreatedAt(LocalDate.now());
        userRepository.save(new UserEntity(user));
    }

}
