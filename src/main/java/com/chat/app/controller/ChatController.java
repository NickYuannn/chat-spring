package com.chat.app.controller;

import com.chat.app.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    @GetMapping("/")
    public String redirectToChat() {
        return "redirect:/chat";
    }

    @MessageMapping("/sendMessage") // end point for sending messages processes and it will
    @SendTo("/topic/messages") //send to specific chatroom
    public ChatMessage sendMessage(ChatMessage message){
        return message;
    }

    @GetMapping("chat")
    public String chat(){
        return "chat"; // name of our thymeleaf template
    }

}
