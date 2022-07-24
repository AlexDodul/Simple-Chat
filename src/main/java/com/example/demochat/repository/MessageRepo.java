package com.example.demochat.repository;

import com.example.demochat.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepo extends JpaRepository<Message, Long> {

    List<Message> findTop50ByOrderByDateDesc();
}
