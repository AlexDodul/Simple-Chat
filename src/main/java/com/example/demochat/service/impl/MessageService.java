package com.example.demochat.service.impl;

import com.example.demochat.dto.ChatForm;
import com.example.demochat.entity.Message;
import com.example.demochat.repository.MessageRepo;
import com.example.demochat.service.IMessageService;
import com.example.demochat.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService implements IMessageService {

    private final MessageRepo messageRepo;
    private final IUserService userService;

    public MessageService(MessageRepo messageRepo, IUserService userService) {
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
