package com.skills.hub.repository;

import com.skills.hub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/*
=========================================================
WHAT IS THIS FILE?
=========================================================

UserRepository is used to communicate with the database
for USER-related operations.

 It automatically handles:
- Save user
- Find user
- Delete user
- Update user

=========================================================

SIMPLE MEANING:
No SQL needed — Spring handles it automatically
=========================================================
*/

public interface UserRepository extends JpaRepository<User, Long> {

    // Custom query method
    // Used for login validation
    User findByEmail(String email);
    User findByName(String name);
}
