package com.example.library.controller.validator;


import com.example.library.entity.User;
import com.example.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
@RequiredArgsConstructor
public class UniqueEmailValidator implements Validator {
    private final UserRepository userRepository;
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            errors.rejectValue("email", "error.emailExists");
        }
    }
}
