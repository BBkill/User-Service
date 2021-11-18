package org.aibles.userservice.service.iml;

import org.aibles.userservice.model.User;
import org.aibles.userservice.repository.UserRepository;
import org.aibles.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceIml implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceIml(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }


    @Override
    public User createUser(User user) {
        User userCreated = userRepository.save(user);
        return userCreated;
    }

    @Override
    public User getUser(int id) {
        return userRepository.findById(id).orElse(null);
    }

}
