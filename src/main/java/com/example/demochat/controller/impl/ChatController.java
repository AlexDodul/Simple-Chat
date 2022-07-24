package com.example.demochat.controller.impl;

import com.example.demochat.dto.ChatForm;
import com.example.demochat.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/chat")
public class ChatController {

    private MessageService messageService;

    public ChatController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public String getChatPage(ChatForm chatForm, Model model) {
        model.addAttribute("messages", this.messageService.getLast50Messages());
        return "chat";
    }

    @PostMapping
    public String postChatMessage(ChatForm chatForm, Model model, Principal principal) {
        chatForm.setUserName(principal.getName());
        this.messageService.addMessage(chatForm);
        chatForm.setMessageText("");
        model.addAttribute("messages", this.messageService.getLast50Messages());
        return "redirect:/chat";
    }

}
