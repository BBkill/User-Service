package org.aibles.userservice.service.iml;

import org.aibles.userservice.model.User;
import org.aibles.userservice.repository.UserRepository;
import org.aibles.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.aibles.userservice.service.Exception.*;

import java.util.List;
import java.util.Optional;

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
        Optional<User> userById= userRepository.findUserByEmail(user.getEmail());
        if(userById.isPresent())
        {
            throw new UserAldreadyExited("Email already Exited");
        }
        else
        {
            return userRepository.save(user);
        }
    }

    @Override
    public List<User> getAllUser() {
        List<User> list = userRepository.findAll();
        if(list.size() != 0 )
        {
            return list;
        }
        else
        {
            throw new UserNotFoundException("No users");
        }

    }

    @Override
    public User getUser(int id) {
        User user = userRepository.findUserById(id).orElse(null);
        if(user != null)
        {
            return user;
        }
        else
        {
            throw new UserNotFoundException("User Not Found");
        }
    }

    @Override
    public User getUser(String email) {
        User user = userRepository.findUserByEmail(email).orElse(null);
        if (user != null)
        {
            return user;
        }
        else
        {
            throw new UserNotFoundException("User Not Found");
        }
    }

    @Override
    public User updateUser(User user) {
        User oldUser = userRepository.findUserByEmail(user.getEmail()).orElse(null);
        if (oldUser != null)
        {
            userRepository.delete(oldUser);
            userRepository.save(user);
            return user;
        }
        else
        {
            throw new UserNotFoundException("User Not Found");
        }
    }

    @Override
    public User deleteUser(User user) {
        User oldUser = userRepository.findUserByEmail(user.getEmail()).orElse(null);
        if (oldUser != null)
        {
            userRepository.delete(user);
            return user;
        }
        else
        {
            throw new UserNotFoundException("User Not Found");
        }
    }

}
