package org.aibles.userservice.controller;

import org.aibles.userservice.model.User;
import org.aibles.userservice.repository.UserRepository;
import org.aibles.userservice.service.Exception.UserNotFoundException;
import org.aibles.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.nio.file.attribute.UserPrincipalNotFoundException;
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
        return ResponseEntity.ok(user);
    }
//    @GetMapping("/{email}")
//    public ResponseEntity<User> getUser(@PathVariable("email") String email) {
//        User user = userService.getUser(email);
//        return ResponseEntity.ok(user);
//    }

    //get all user in db
    @GetMapping
    public ResponseEntity<List<User>> getUser()
    {
        List<User> userList = userService.getAllUser();
        return ResponseEntity.ok(userList);
    }


    //put user which is not in db
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        return ResponseEntity.ok(userService.createUser(user));
    }

    //delete user which has email in db
    @DeleteMapping(path = "/email/{email}")
    public ResponseEntity<User> deleteUser(@PathVariable("email") String email)
    {
        User user = userService.getUser(email);
        return ResponseEntity.ok(userService.deleteUser(user));
    }

    //update user :v
    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user)
    {
        return ResponseEntity.ok(userService.updateUser(user));
    }

}
