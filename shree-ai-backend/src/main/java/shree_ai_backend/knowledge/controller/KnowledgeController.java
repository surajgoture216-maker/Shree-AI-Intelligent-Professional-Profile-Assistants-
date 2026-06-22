package shree_ai_backend.knowledge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import shree_ai_backend.knowledge.entity.Knowledge;
import shree_ai_backend.knowledge.service.KnowledgeService;

@RestController
public class KnowledgeController {

    @Autowired
    private KnowledgeService knowledgeService;

    @GetMapping("/api/knowledge")
    public List<Knowledge> getAllKnowledge() {
        return knowledgeService.getAllKnowledge();
    }
    @PostMapping("/api/knowledge")
public Knowledge saveKnowledge(@RequestBody Knowledge knowledge) {
    return knowledgeService.saveKnowledge(knowledge);
}
    @GetMapping("/api/knowledge/{id}")
public Knowledge getKnowledgeById(@PathVariable Long id) {
    return knowledgeService.getKnowledgeById(id);
}
   @DeleteMapping("/api/knowledge/{id}")
public void deleteKnowledge(@PathVariable Long id) {
    knowledgeService.deleteKnowledge(id);
}
   @PutMapping("/api/knowledge/{id}")
public Knowledge updateKnowledge(@PathVariable Long id,@RequestBody Knowledge knowledge) {
    return knowledgeService.updateKnowledge(id, knowledge);
}
}