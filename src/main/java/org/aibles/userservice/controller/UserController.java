package org.aibles.userservice.controller;

import org.aibles.userservice.model.User;
import org.aibles.userservice.repository.UserRepository;
import org.aibles.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/v1/userinfo")
public class UserController {
    @Autowired
    private UserService userService;

    //get user by id
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") int id) {
        User user = userService.getUser(id);
        if (user != null)
        {
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //get all user in db
    @GetMapping
    public List<User> getUser()
    {
        return userService.getAllUser();
    }


    //put user which is not in db
    @PostMapping
    public String createUser(@RequestBody User newUser)
    {
        User oldUser = userService.getUser(newUser.getId());
        if(oldUser == null)
        {
            userService.createUser(newUser);
            return "user is saved";
        }
        return "id is taken";
    }

    //delete user which has id in db
    @DeleteMapping(path = "/{id}")
    public String deleteUser(@PathVariable("id") int id)
    {
        User user = userService.getUser(id);
        if (user != null)
        {
            userService.deleteUser(id);
            return "delete successful";
        }
        return "user not found";
    }

    //delete all user in db
    @DeleteMapping
    public String deleteAllUser()
    {
        userService.deleteAllUser();
        return "delete all user successful";
    }


    //update user :v
    @PutMapping(path = "/{id}")
    public String updateUser(@RequestBody User user)
    {
        userService.updateUser(user);
        return "updated";
    }



}
