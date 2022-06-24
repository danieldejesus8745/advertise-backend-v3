package com.advertise.adapters.outbound;

import com.advertise.application.domain.User;
import com.advertise.application.ports.outbound.UserServicePort;
import com.advertise.entities.UserEntity;
import com.advertise.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceAdapterOutbound implements UserServicePort {

    private final UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.save(new UserEntity(user));
    }

    @Override
    public String login(String email) {
        UserEntity userEntity = userRepository.findByEmail(email).orElse(null);

        if (Objects.isNull(userEntity)) {
            throw new IllegalStateException("Usuário não encontrado");
        }

        return userEntity.getPassword();
    }

}
