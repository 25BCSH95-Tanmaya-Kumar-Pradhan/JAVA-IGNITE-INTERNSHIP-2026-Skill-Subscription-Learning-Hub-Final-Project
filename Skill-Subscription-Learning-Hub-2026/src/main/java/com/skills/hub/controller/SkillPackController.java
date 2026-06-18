package com.skills.hub.controller;

import com.skills.hub.model.SkillPack;
import com.skills.hub.model.Subscription;
import com.skills.hub.model.User;
import com.skills.hub.service.SkillPackService;
import com.skills.hub.service.SubscriptionService;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@Controller
public class SkillPackController {

    private final SkillPackService packService;
    private final SubscriptionService subscriptionService;

    public SkillPackController(
            SkillPackService packService,
            SubscriptionService subscriptionService) {

        this.packService = packService;
        this.subscriptionService = subscriptionService;
    }

    @GetMapping("/packs")
    public String viewPacks(Model model,
                            HttpSession session) {

        var list = packService.getAllPacks();

        model.addAttribute("packs", list);

        User user = (User) session.getAttribute("loggedInUser");

        if (user != null) {

            List<Long> subscribedPackIds =
                    subscriptionService.getUserSubscriptions(user.getId())
                            .stream()
                            .map(sub -> sub.getSkillPack().getId())
                            .collect(Collectors.toList());

            model.addAttribute("subscribedPackIds", subscribedPackIds);
        }

        return "packs";
    }

    @GetMapping("/add-pack")
    public String showAddPackPage() {

        return "add-pack";
    }

    @PostMapping("/add-pack")
    public String addPack(@ModelAttribute SkillPack pack) {

        packService.addSkillPack(pack);

        return "redirect:/packs";
    }

    @GetMapping("/delete-pack/{id}")
    public String deletePack(@PathVariable Long id) {

        packService.deleteSkillPack(id);

        return "redirect:/packs";
    }

    @PostMapping("/update-pack")
    public String updatePack(@ModelAttribute SkillPack pack) {

        System.out.println("ID = " + pack.getId());
        System.out.println("Title = " + pack.getTitle());
        System.out.println("Description = " + pack.getDescription());
        System.out.println("Price = " + pack.getPrice());

        packService.updateSkillPack(pack);

        return "redirect:/packs";
    }
}
