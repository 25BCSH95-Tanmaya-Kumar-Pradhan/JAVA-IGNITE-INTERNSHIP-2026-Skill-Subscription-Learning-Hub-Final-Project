package com.skills.hub.service.impl;

import com.skills.hub.model.SkillPack;
import com.skills.hub.model.Subscription;
import com.skills.hub.model.User;
import com.skills.hub.repository.SkillPackRepository;
import com.skills.hub.repository.SubscriptionRepository;
import com.skills.hub.repository.UserRepository;
import com.skills.hub.service.SubscriptionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subRepo;
    private final UserRepository userRepo;
    private final SkillPackRepository packRepo;

    public SubscriptionServiceImpl(
            SubscriptionRepository subRepo,
            UserRepository userRepo,
            SkillPackRepository packRepo) {

        this.subRepo = subRepo;
        this.userRepo = userRepo;
        this.packRepo = packRepo;
    }

    @Override
    public Subscription subscribe(Long userId, Long packId) {

        //fetch user
        User user = userRepo.findById(userId).orElse(null);

        //fetch skill pack
        SkillPack pack = packRepo.findById(packId).orElse(null);

        //validate
        if (user == null || pack == null) {
            return null;
        }

        //create subscription
        Subscription subscription = new Subscription();

        subscription.setUser(user);
        subscription.setSkillPack(pack);

        // dates
        subscription.setStartDate(LocalDate.now());
        subscription.setEndDate(LocalDate.now().plusDays(30));

        // status
        subscription.setStatus("ACTIVE");

        // save and return
        return subRepo.save(subscription);
    }

    @Override
    public List<Subscription> getUserSubscriptions(Long userId) {
    	//fetching user from the ID
        User user = userRepo.findById(userId).orElse(null);
        //checking if there's user there or not if not life is shown
        if (user == null) {
            return List.of();
        }
        //else the user found is shown here
        return subRepo.findByUser(user);
    }

    public SubscriptionRepository getSubRepo() {
        return subRepo;
    }
}
