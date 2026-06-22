package shree_ai_backend.knowledge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shree_ai_backend.knowledge.entity.Knowledge;

@Repository
public interface KnowledgeRepository extends JpaRepository<Knowledge, Long> {

}