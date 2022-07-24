package com.example.demochat.service;

import com.example.demochat.dto.ChatForm;
import com.example.demochat.entity.Message;

import java.util.List;

public interface IMessageService {
    void addMessage(ChatForm chatForm);

    List<Message> getLast50Messages();
}
