package shree_ai_backend.knowledge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shree_ai_backend.knowledge.entity.Knowledge;
import shree_ai_backend.knowledge.repository.KnowledgeRepository;

@Service
public class KnowledgeService {

    @Autowired
    private KnowledgeRepository knowledgeRepository;

    public List<Knowledge> getAllKnowledge() {
        return knowledgeRepository.findAll();
    }

    public Knowledge saveKnowledge(Knowledge knowledge) {
    return knowledgeRepository.save(knowledge);
   }

   public Knowledge getKnowledgeById(Long id) {
    return knowledgeRepository.findById(id).orElse(null);
}
   public void deleteKnowledge(Long id) {
    knowledgeRepository.deleteById(id);
}
  public Knowledge updateKnowledge(Long id, Knowledge knowledge) {

    Knowledge existing = knowledgeRepository.findById(id)
            .orElseThrow();

    existing.setCategory(knowledge.getCategory());
    existing.setTitle(knowledge.getTitle());
    existing.setContent(knowledge.getContent());

    return knowledgeRepository.save(existing);
}
   
}