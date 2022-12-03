package com.example.library.controller;

import com.example.library.controller.validator.UniqueEmailValidator;
import com.example.library.entity.User;
import com.example.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final UniqueEmailValidator uniqueEmailValidator;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "auth/login";
    }

    @GetMapping("/sign-up")
    public String signUp(Model model) {
        model.addAttribute("user", new User());
        return "auth/signup";
    }

    @PostMapping("/sign-up")
    public String login(@Valid User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        uniqueEmailValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "auth/signup";
        }
        userService.signUp(user);
        redirectAttributes.addAttribute("warning", "auth.signup.confirm");
        return "redirect:/auth/login";
    }

    @GetMapping("/confirm")
    public String confirm(@RequestParam String token, RedirectAttributes redirectAttributes) {
        userService.confirm(token);
        redirectAttributes.addAttribute("message", "auth.email.confirm");
        return "redirect:/auth/login";
    }
}
