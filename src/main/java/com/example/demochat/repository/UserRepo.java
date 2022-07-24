package com.example.demochat.repository;

import com.example.demochat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

    User getByName(String name);
}
