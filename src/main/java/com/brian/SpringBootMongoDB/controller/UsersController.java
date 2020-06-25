package com.brian.SpringBootMongoDB.controller;

import com.brian.SpringBootMongoDB.document.Users;
import com.brian.SpringBootMongoDB.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/rest/users")
public class UsersController {

    @Autowired
    private UsersRepository UsersRepository;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Users> getAllUsers() {
        System.out.println("get all users");
        List<Users> users = UsersRepository.findAll();
        for (Users each : users) {
            System.out.println(each.toString());
        }
        return users;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Users> getUserById(@PathVariable Integer id) {
        System.out.println("get user by ID: " + id);
        Optional<Users> user = UsersRepository.findById(id);

        if (user.isPresent()) {
            System.out.println(user.toString());
            return user;
        }
        System.out.println("no user by that id");
        return null;
    }


    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public String addUser(@RequestBody Users users) {
        if (null != users) {
            System.out.println("adding a new user");
            System.out.println(users.toString());
            UsersRepository.insert(users);
            return "new user was added";
        }

        return "please enter user with correct values";

    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {

        Optional<Users> user = UsersRepository.findById(id);
        Users deletedUser;

        if (user.isPresent()) {
            deletedUser = user.get();
            System.out.println(deletedUser.toString());
            UsersRepository.deleteById(id);

            return "deleted user: " + deletedUser.toString();
        }

        return "user Id was not valid";
    }

    @PutMapping("/update/{id}")
    public Users updateUser(@RequestBody Users users, @PathVariable Integer id) {

        System.out.println("updating user: " + users.toString());

        UsersRepository.updateUser(users, id);

        return null;
    }

    @PutMapping("/findandmodify/{id}")
    public Users findAndModify(@RequestBody Users users, @PathVariable Integer id) {

        System.out.println("find and modify user: " + users.toString());

        Users fromService = UsersRepository.findOneAndModify(users, id);

        return fromService;
    }


}
