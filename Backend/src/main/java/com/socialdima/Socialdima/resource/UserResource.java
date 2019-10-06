/**
 * @author Baranov DA
 * @version 1.99
 */
package com.socialdima.Socialdima.resource;

import com.socialdima.Socialdima.model.User;
import com.socialdima.Socialdima.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller for DB-table user
 */
@RestController
@RequestMapping(value = "/user")
public class UserResource {
    @Autowired
    UserRepository userRepository;

    /**
     * if path = "/user"
     * @return data of all users
     */
//    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<User> getAll() {
        return userRepository.findAll();
    }

    /**
     * if path = "/user/{id}"
     * @param id - user-id
     * @return data of user with this id
     */
    @GetMapping("/{id}")
    public Optional<User> getOne(@PathVariable Integer id) {
        return userRepository.findById(id);
    }

    /**
     * delete user with this id
     * @param id - id of user that will be deleted
     */
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        userRepository.deleteById(id);
    }

    /**
     * if path = "user/register" - register the user
     * @param user - register data of user
     * @return data of all users
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/register")
    public List<User> register(@RequestBody final User user) {
        userRepository.save(user);
        return userRepository.findAll();
    }

    /**
     * if path = "user/search/name" - search user by name
     * @param name - nickname of user
     * @return data of user
     */
    @GetMapping("/search/{name}")
    public User searchByName(@PathVariable String name) {
        return userRepository.findByName(name);
    }

    /**
     * if path = "user/login" - authorize the user
     * @param user - data of user
     * @return data of user
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    public User login(@RequestBody final User user) {
        return userRepository.findByLoginAndPassword(user.getLogin(), user.getPassword());
    }

    /**
     * edit the userdata
     * @param user - data of user
     * @return null
     */
    @PutMapping("/edit")
    public User edit(@RequestBody final User user) {
        return userRepository.save(user);
    }
}

