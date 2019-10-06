/**
 * @author Baranov DA
 * @version 1.99
 */
package com.socialdima.Socialdima.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
    /**
     * @attribute id - id user
     */
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Integer id;

    /**
     * @attribute nickname - nickname of this user
     */
    @Column(name = "nickname")
    private String name;

    /**
     * @attribute login - login for user-authorization
     */
    @Column(name = "login")
    private String login;

    /**
     * @attribute password - password for user-authorization
     */
    @Column(name = "password")
    private String password;

    /**
     * @attribute avatar - path of user-avatar image
     */
    @Column(name = "avatar")
    private Integer avatar;

    public User() {
    }

    /**
     * Getter for user id
     *
     * @return id user
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter for user id
     *
     * @param id - id user
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter for name
     *
     * @return user nickname of this user
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name
     *
     * @param name - nickname of this user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for login
     *
     * @return login for user-authorization
     */
    public String getLogin() {
        return login;
    }

    /**
     * Setter for login
     *
     * @param login - login for user-authorization
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Getter for password
     *
     * @return password for user-authorization
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter for password
     *
     * @param password - password for user-authorization
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter for avatar
     *
     * @return path of user-avatar image
     */
    public Integer getAvatar() {
        return avatar;
    }

    /**
     * setter for avatar
     *
     * @param avatar - path of user-avatar image
     */
    public void setAvatar(Integer avatar) {
        this.avatar = avatar;
    }
}
