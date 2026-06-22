package shree_ai_backend.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shree_ai_backend.admin.dto.PromptRequest;
import shree_ai_backend.knowledge.entity.Knowledge;
import shree_ai_backend.knowledge.repository.KnowledgeRepository;

@Service
public class AdminService {

    @Autowired
    private KnowledgeRepository knowledgeRepository;

    public String processPrompt(PromptRequest request) {

    String prompt = request.getPrompt().toLowerCase();

    Knowledge knowledge = new Knowledge();

    if(prompt.contains("skill")) {

        knowledge.setCategory("Skill");
        knowledge.setTitle(request.getPrompt());
        knowledge.setContent(request.getPrompt());

    } else if(prompt.contains("project")) {

        knowledge.setCategory("Project");
        knowledge.setTitle(request.getPrompt());
        knowledge.setContent(request.getPrompt());

    } else if(prompt.contains("education")) {

        knowledge.setCategory("Education");
        knowledge.setTitle(request.getPrompt());
        knowledge.setContent(request.getPrompt());

    } else {

        knowledge.setCategory("General");
        knowledge.setTitle(request.getPrompt());
        knowledge.setContent(request.getPrompt());
    }

    knowledgeRepository.save(knowledge);

    return "Prompt processed successfully";
}
}