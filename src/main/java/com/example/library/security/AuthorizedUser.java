package com.example.library.security;

import com.example.library.entity.User;
import lombok.Getter;

@Getter
public class AuthorizedUser extends org.springframework.security.core.userdetails.User {
    private final User user;

    public AuthorizedUser(User user) {
        super(user.getEmail(), user.getPassword(), user.isEnabled(), true, true, true, user.getRoles());
        this.user = user;

    }
}
