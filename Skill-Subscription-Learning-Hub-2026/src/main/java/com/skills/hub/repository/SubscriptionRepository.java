package com.skills.hub.repository;

import com.skills.hub.model.Subscription;
import com.skills.hub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
=========================================================
WHAT IS THIS FILE?
=========================================================

SubscriptionRepository manages database operations
for user subscriptions.

 It connects:
User <-> SkillPack

=========================================================
*/

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    // Get all subscriptions for a specific user
    List<Subscription> findByUser(User user);
   //Gets whether there is the existing user in the base or not
    Subscription findByUserIdAndSkillPackId(Long userId, Long packId);

}
