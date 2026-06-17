package com.skills.hub.service.impl;

import com.skills.hub.model.User;
import com.skills.hub.repository.UserRepository;
import com.skills.hub.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User registerUser(User user) {

        //Checking if email already exists
        User existingUser = userRepo.findByEmail(user.getEmail());

        //If exists, stop process
        if (existingUser != null) {
            return null;
        }

        //Else Save user to DB
        User savedUser = userRepo.save(user);

        //Then return saved user
        return savedUser;
    }

    @Override
    public User login(String email, String password) {

        //We find user by email
        User user = userRepo.findByEmail(email);

        // If user not found we return
        if (user == null) {
            return null;
        }

        //Check password and return user
        if (user.getPassword().equals(password)) {
            return user;
        }

        //If password incorrect
        return null;
    }
}
