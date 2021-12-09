package org.aibles.userservice.service.Exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends AbstractException{

    public UserNotFoundException()
    {
        super("User not found", HttpStatus.NOT_FOUND);
    }

}
