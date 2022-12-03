package com.example.library.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    LIBRARIAN;

    @Override
    public String getAuthority() {
        return "ROLE_" + name();
    }
}
