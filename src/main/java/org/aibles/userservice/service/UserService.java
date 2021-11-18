package org.aibles.userservice.service;

import org.aibles.userservice.model.User;

public interface UserService {
    User createUser(User user);
    User getUser(int id);
}
