package com.advertise.controllers;

import com.advertise.adapters.inbound.UserServiceAdapterInbound;
import com.advertise.application.domain.User;
import com.advertise.application.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/users")
public class UserController {

    private final UserServiceAdapterInbound userServiceAdapterInbound;
    private final PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<HttpStatus> addUser(@RequestBody UserDTO userDTO) {
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userServiceAdapterInbound.addUser(new User(userDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(HttpStatus.CREATED);
    }

}
