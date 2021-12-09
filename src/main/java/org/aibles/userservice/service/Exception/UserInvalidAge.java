package org.aibles.userservice.service.Exception;

import org.springframework.http.HttpStatus;

public class UserInvalidAge extends AbstractException{
    public UserInvalidAge()
    {
        super("invalid age, age must be in range 18 to 100", HttpStatus.BAD_REQUEST);
    }
}
