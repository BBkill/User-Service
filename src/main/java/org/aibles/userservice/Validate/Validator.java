package org.aibles.userservice.Validate;

import org.aibles.userservice.model.User;
import org.aibles.userservice.service.Exception.UserEmailInvalidException;
import org.aibles.userservice.service.Exception.UserEmailNullException;
import org.aibles.userservice.service.Exception.UserInvalidAge;
import org.aibles.userservice.service.Exception.UserNameException;

public class Validator {
    private User user = new User();
    public Validator(){};
    public void validateUserName(User user)
    {
        if(user.getName().length() < 1 )
        {
            throw  new UserNameException();
        }
        else {
            return;
        }
    }
    public void validateUserAge(User user)
    {
        if(user.getAge()<18 || user.getAge() >100)
        {
            throw new UserInvalidAge();
        }
        else{
            return;
        }
    }
    public void validateUserEmail(User user)
    {
        if(user.getEmail().length()<1)
        {
            throw new UserEmailNullException();
        }
        else  if(!user.getEmail().contains("@gmail.com"))
        {
            throw new UserEmailInvalidException();
        }
        else{
            return;
        }
    }
}
