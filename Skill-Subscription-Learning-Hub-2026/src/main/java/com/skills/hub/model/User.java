package com.skills.hub.model;

import jakarta.persistence.*;

/*
=========================================================
WHAT IS THIS CLASS?
=========================================================

This class represents a USER in the system.

 Each object of this class = one user in database

Example:
- id = 1, name = Hari, email = test@gmail.com

=========================================================

WHAT DOES IT DO?
- Stores user data
- Maps to database table "users"
=========================================================
*/

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    @Column(unique = true)
    private String email;
    private String password;

    // =========================
    // GETTERS AND SETTERS
    // =========================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        // TASK: assign user id
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        // TASK: store user name
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        // TASK: store email
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        // TASK: store password
        this.password = password;
    }
}
