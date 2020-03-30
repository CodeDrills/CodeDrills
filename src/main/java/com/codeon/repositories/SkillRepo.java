package com.codeon.repositories;

import com.codeon.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepo extends JpaRepository<Skill, Long> {
    public Skill findSkillById(Long id);
    public Skill findSkillByName(String skillName);
}
