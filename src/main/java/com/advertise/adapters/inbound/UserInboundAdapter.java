package com.advertise.adapters.inbound;

import com.advertise.application.domain.Token;
import com.advertise.application.domain.User;
import com.advertise.application.ports.inbound.UserInboundPort;
import com.advertise.application.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.advertise.application.utils.Messages.INVALID_CREDENTIALS;
import static com.advertise.application.utils.Messages.USER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class UserInboundAdapter implements UserInboundPort {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final TokenInboundAdapter tokenInboundAdapter;

    @Override
    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.addUser(user);
    }

    @Override
    public String login(String email, String password) {
        User userFound = userService.login(email);

        if (Objects.isNull(userFound.getUuid())) return USER_NOT_FOUND.getDescription();

        if (!passwordEncoder.matches(password, userFound.getPassword())) return INVALID_CREDENTIALS.getDescription();

        Token token = tokenInboundAdapter.createToken(userFound.getUuid());
        return tokenInboundAdapter.addToken(token);
    }

}
