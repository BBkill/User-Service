package org.aibles.userservice.service;

import org.aibles.userservice.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void createUser(User user);
    List<User> getAllUser();
    User getUser(int id);

    void deleteUser(int id);
    void deleteAllUser();
    //Optional<User> findUserById(int );
}
