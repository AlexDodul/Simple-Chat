package com.example.demochat.service;

import com.example.demochat.entity.User;

public interface IUserService {
    User createUser(User user);

    User getByName(String name);
}
