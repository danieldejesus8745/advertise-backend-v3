package com.advertise.mappers;

import com.advertise.application.domain.User;
import com.advertise.dto.UserDTO;
import com.advertise.entities.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public User fromDTO(UserDTO userDTO) {
        User user = new User();
        user.setUuid(userDTO.getUuid());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setCreatedAt(userDTO.getCreatedAt());
        return user;
    }

    public User toUser(UserEntity userEntity) {
        User user = new User();
        user.setUuid(userEntity.getUuid());
        user.setName(userEntity.getName());
        user.setEmail(userEntity.getEmail());
        user.setPassword(userEntity.getPassword());
        user.setCreatedAt(userEntity.getCreatedAt());
        return user;
    }

    public UserEntity toUserEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUuid(user.getUuid());
        userEntity.setName(user.getName());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());
        userEntity.setCreatedAt(user.getCreatedAt());
        return userEntity;
    }

}
