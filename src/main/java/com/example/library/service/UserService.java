package com.example.library.service;

import com.example.library.entity.User;
import com.example.library.exception.NotFoundException;
import com.example.library.repository.UserRepository;
import com.example.library.security.AuthorizedUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User getById(int id) {
        return userRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).map(AuthorizedUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("User is not found"));
    }

    @Transactional
    public User signUp(User user) {
        user.setEnabled(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Transactional
    public void confirm(String token) {
//        User user = userRepository.findByToken(token).orElseThrow(NotFoundException::new);
//        user.setToken(null);
//        user.setEnabled(true);
    }
}
