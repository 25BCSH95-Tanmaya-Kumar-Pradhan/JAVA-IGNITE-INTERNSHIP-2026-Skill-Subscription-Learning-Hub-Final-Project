package com.skills.hub.model;

import jakarta.persistence.*;

/*
=========================================================
WHAT IS THIS CLASS?
=========================================================

This represents a SKILL PACK (like a course)

 Example:
- Java Basics
- Spring Boot Mastery
- Python Fundamentals

Each object = one course

=========================================================
*/

@Entity
@Table(name = "skill_packs")
public class SkillPack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Double price;

    // =========================
    // GETTERS AND SETTERS
    // =========================
    public SkillPack() {
     
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        //  assign id
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        // store course title
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        //  store course description
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        // store price
        this.price = price;
    }
}
