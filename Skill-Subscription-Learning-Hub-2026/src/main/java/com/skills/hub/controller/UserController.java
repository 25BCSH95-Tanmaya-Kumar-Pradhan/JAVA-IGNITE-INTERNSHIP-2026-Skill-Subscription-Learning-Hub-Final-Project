package com.skills.hub.controller;

import com.skills.hub.model.User;
import com.skills.hub.service.UserService;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/register")
    public String showRegisterPage() {

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
                        @RequestParam String password,
                        HttpSession session) {

        User user = userService.login(email, password);

        if (user != null) {

            // Store logged-in user in session
            session.setAttribute("loggedInUser", user);

            return "redirect:/packs";
        }

        return "login";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "redirect:/login";
    }
    
    public UserService getUserService() {
        return userService;
    }
    
    @PostConstruct
    public void test() {
        System.out.println("USER CONTROLLER LOADED");
    }
}
