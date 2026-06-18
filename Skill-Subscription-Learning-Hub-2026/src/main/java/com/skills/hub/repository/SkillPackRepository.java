package com.skills.hub.repository;

import com.skills.hub.model.SkillPack;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
/*
=========================================================
WHAT IS THIS FILE?
=========================================================

SkillPackRepository handles database operations
for SkillPack (courses).

 Used for:
- Adding new courses
- Viewing courses
- Updating courses
- Deleting courses

=========================================================
*/

public interface SkillPackRepository extends JpaRepository<SkillPack, Long> {
    // No custom methods needed initially
	List<SkillPack> findByTitleContainingIgnoreCase(String keyword);
}
