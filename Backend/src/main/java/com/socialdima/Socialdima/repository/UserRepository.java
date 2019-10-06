package com.socialdima.Socialdima.repository;

import com.socialdima.Socialdima.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * interface for image
 * generates automatically
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    /**
     * Find user by nickname
     * @param name - user-nickname
     * @return user-data
     */
    User findByName(String name);

    /**
     * Authorize the user
     * @param login - user-login
     * @param password - user-password
     * @return
     */
    User findByLoginAndPassword(String login, String password);
}
