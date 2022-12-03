package com.example.library.entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    private boolean enabled;
//    private String token;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    @CollectionTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"))
    private Set<Role> roles;
}
