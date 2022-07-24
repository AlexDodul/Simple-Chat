package com.example.demochat.service;

import com.example.demochat.dto.ChatForm;
import com.example.demochat.entity.Message;
import com.example.demochat.repository.MessageRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final MessageRepo messageRepo;
    private final UserService userService;

    public MessageService(MessageRepo messageRepo, UserService userService) {
        this.messageRepo = messageRepo;
        this.userService = userService;
    }

    public void addMessage(ChatForm chatForm) {
        Message newMessage = new Message();
        newMessage.setMessage(chatForm.getMessageText());
        newMessage.setUser(userService.getByName(chatForm.getUserName()));
        messageRepo.save(newMessage);
    }

    public List<Message> getLast50Messages() {
        return messageRepo.findTop50ByOrderByDateDesc();
    }
}
