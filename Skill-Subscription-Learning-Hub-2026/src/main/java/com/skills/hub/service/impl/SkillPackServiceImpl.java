package com.skills.hub.service.impl;

import com.skills.hub.model.SkillPack;
import com.skills.hub.repository.SkillPackRepository;
import com.skills.hub.service.SkillPackService;
import org.springframework.stereotype.Service;
import com.skills.hub.repository.SubscriptionRepository;

import java.util.List;

@Service
public class SkillPackServiceImpl implements SkillPackService {
	//a private class instance is created to store all the packs and finalized
    private final SkillPackRepository packRepo;
    private final SubscriptionRepository subscriptionRepo;
    //the pack is given and saved in the class instance
    public SkillPackServiceImpl(SkillPackRepository packRepo,
            SubscriptionRepository subscriptionRepo) {
    	this.packRepo = packRepo;
    	this.subscriptionRepo = subscriptionRepo;
    }

    @Override
    public SkillPack addSkillPack(SkillPack pack) {
    	//saves the pack given by the user
        return packRepo.save(pack);
    }

    @Override
    public List<SkillPack> getAllPacks() {
    	//the packs stored, all of them are displayed
        return packRepo.findAll();
    }

    @Override
    public SkillPack updateSkillPack(SkillPack pack) {

        System.out.println("Service Called");
        System.out.println(pack.getId());

        if (!packRepo.existsById(pack.getId())) {
            System.out.println("Pack not found!");
            return null;
        }

        return packRepo.save(pack);
    }

    @Override
    public void deleteSkillPack(Long id) {

        if (subscriptionRepo.existsBySkillPackId(id)) {
            throw new RuntimeException(
                "This Skill Pack has active subscribers and cannot be deleted."
            );
        }

        packRepo.deleteById(id);
    }
    
    @Override
    public List<SkillPack> searchPacks(String keyword) {

        return packRepo.findByTitleContainingIgnoreCase(keyword);

    }

    public SkillPackRepository getPackRepo() {
        return packRepo;
    }
}
