package org.aibles.userservice.service.iml;

import org.aibles.userservice.Validate.Validator;
import org.aibles.userservice.model.User;
import org.aibles.userservice.repository.UserRepository;
import org.aibles.userservice.service.Exception.UserAlreadyExited;
import org.aibles.userservice.service.Exception.UserNotFoundException;
import org.aibles.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceIml implements UserService {

    private final UserRepository userRepository;
    private final Validator validator = new Validator();
    @Autowired
    public UserServiceIml(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }

    @Override
    public User createUser(User user) throws UserAlreadyExited {
        validator.validateUserName(user);
        validator.validateUserAge(user);
        validator.validateUserEmail(user);
        User userByEmail = userRepository.findUserByEmail(user.getEmail()).orElse(null);
        if(userByEmail != null)
        {
            throw new UserAlreadyExited();
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
            throw new UserNotFoundException();
        }

    }

    @Override
    public User getUser(int id) {
        User user = userRepository.findById(id).orElse(null);
        if(user != null)
        {
            return user;
        }
        else
        {
            throw new UserNotFoundException();
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
            throw new UserNotFoundException();
        }
    }

    @Override
    public User updateUser(User user) {
        validator.validateUserName(user);
        validator.validateUserAge(user);
        validator.validateUserEmail(user);
        User oldUser = userRepository.findUserByEmail(user.getEmail()).orElse(null);
        if (oldUser != null)
        {
            userRepository.delete(oldUser);
            userRepository.save(user);
            return user;
        }
        else
        {
            throw new UserNotFoundException();
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
            throw new UserNotFoundException();
        }
    }

}
