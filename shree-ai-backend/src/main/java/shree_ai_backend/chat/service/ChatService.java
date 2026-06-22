package shree_ai_backend.chat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shree_ai_backend.ai.service.OllamaService;
import shree_ai_backend.chat.dto.ChatRequest;
import shree_ai_backend.chat.dto.ChatResponse;
import shree_ai_backend.knowledge.entity.Knowledge;
import shree_ai_backend.knowledge.repository.KnowledgeRepository;

@Service
public class ChatService {
    @Autowired
    private OllamaService ollamaService ;
   
    @Autowired
    private KnowledgeRepository knowledgeRepository;

    public ChatResponse askQuestion(ChatRequest request) {

    String question = request.getQuestion();

    List<Knowledge> data = knowledgeRepository.findAll();

    StringBuilder context = new StringBuilder();

    for (Knowledge k : data) {
        context.append("Category: ")
                .append(k.getCategory())
                .append(", Title: ")
                .append(k.getTitle())
                .append(", Content: ")
                .append(k.getContent())
                .append("\n");
    }

    String prompt = """
You are Shree AI, the personal AI assistant of Suraj Goture.

IMPORTANT RULES:

- Answer professionally.
- Treat Suraj Goture as a person, not an AI model.
- Use only the provided knowledge base.
- Do not invent information.
- If information is unavailable, say:
  "I don't have enough information about that yet."

Knowledge Base:

%s

User Question:

%s

Provide a concise professional answer.
""".formatted(context.toString(), question);


        try {
    String answer = ollamaService.ask(prompt);
    return new ChatResponse(answer);
       } catch (Exception e) {
    e.printStackTrace();
    return new ChatResponse(e.getMessage());
       }
    }

}