package org.aibles.userservice.service.Exception;

import org.springframework.http.HttpStatus;

public class UserNameException extends AbstractException{
    public UserNameException()
    {
        super("name must not be null", HttpStatus.BAD_REQUEST);
    }
}
