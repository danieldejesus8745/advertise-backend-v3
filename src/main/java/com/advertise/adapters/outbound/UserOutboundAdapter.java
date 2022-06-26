package com.advertise.adapters.outbound;

import com.advertise.application.domain.User;
import com.advertise.application.ports.outbound.UserOutboundPort;
import com.advertise.entities.UserEntity;
import com.advertise.mappers.UserMapper;
import com.advertise.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.advertise.application.utils.Messages.EMAIL_ALREADY_REGISTERED;

@Service
@RequiredArgsConstructor
public class UserOutboundAdapter implements UserOutboundPort {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void addUser(User user) {
        try {
            userRepository.save(userMapper.toUserEntity(user));
        } catch (DataIntegrityViolationException | ConstraintViolationException exception) {
            throw new IllegalStateException(EMAIL_ALREADY_REGISTERED.getDescription());
        }
    }

    @Override
    public User login(String email) {
        UserEntity userFound = userRepository.findByEmail(email).orElse(null);

        if (Objects.isNull(userFound)) {
            return userMapper.toUser(new UserEntity());
        }

        return userMapper.toUser(userFound);
    }

}
