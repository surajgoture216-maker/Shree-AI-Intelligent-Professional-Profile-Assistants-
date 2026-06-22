package shree_ai_backend.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shree_ai_backend.chat.dto.ChatRequest;
import shree_ai_backend.chat.dto.ChatResponse;
import shree_ai_backend.chat.service.ChatService;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins = "http://localhost:4200")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping
    public ChatResponse askQuestion(@RequestBody ChatRequest request) {
        return chatService.askQuestion(request);
    }
}