package com.advertise.controllers;

import com.advertise.adapters.inbound.UserInboundAdapter;
import com.advertise.dto.UserDTO;
import com.advertise.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import static com.advertise.application.utils.Messages.INVALID_CREDENTIALS;
import static com.advertise.application.utils.Messages.USER_NOT_FOUND;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/users")
public class UserController {

    private final UserMapper userMapper;
    private final UserInboundAdapter userServiceAdapterInbound;

    @PostMapping
    public ResponseEntity<HttpStatus> addUser(@RequestBody UserDTO userDTO) {
        userServiceAdapterInbound.addUser(userMapper.fromDTO(userDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(HttpStatus.CREATED);
    }

    @GetMapping(path = "/login/{email}/{password}")
    public ResponseEntity<String> login(@PathVariable("email") String email,
                                        @PathVariable("password") String password) {
        String response = userServiceAdapterInbound.login(email, password);

        if (response.equals(USER_NOT_FOUND.getDescription()))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(USER_NOT_FOUND.getDescription());

        if (response.equals(INVALID_CREDENTIALS.getDescription()))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(INVALID_CREDENTIALS.getDescription());

        return ResponseEntity.ok(response);
    }

}
