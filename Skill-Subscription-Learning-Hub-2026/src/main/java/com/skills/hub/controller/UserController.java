package com.skills.hub.controller;

import com.skills.hub.model.User;
import com.skills.hub.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegisterPage() {

        //Return register page
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {

        
        User savedUser = userService.registerUser(user);

        
        if (savedUser != null) {
            return "redirect:/login";
        }

        return "register";
    }

    @GetMapping("/login")
    public String showLoginPage() {

        
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password) {

        
        User user = userService.login(email, password);

        
        if (user != null) {
            return "redirect:/packs";
        }

        return "login";
    }

    public UserService getUserService() {
        return userService;
    }
}
