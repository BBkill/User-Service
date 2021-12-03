package org.aibles.userservice.service;

import org.aibles.userservice.model.User;
import org.aibles.userservice.service.Exception.UserNotFoundException;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user);
    List<User> getAllUser();
    User getUser(int id);
    User getUser(String email);
    User deleteUser(User user);

    User updateUser(User user);

    //Optional<User> findUserById(int id);
}
