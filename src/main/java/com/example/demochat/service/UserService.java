package com.example.demochat.service;

import com.example.demochat.entity.User;
import com.example.demochat.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public User getByName(String name){
        return userRepo.getByName(name);
    }
}
