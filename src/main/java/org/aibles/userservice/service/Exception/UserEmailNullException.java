package org.aibles.userservice.service.Exception;

import org.springframework.http.HttpStatus;

public class UserEmailNullException extends AbstractException{
    public UserEmailNullException()
    {
        super("Email must not be null", HttpStatus.BAD_REQUEST);
    }
}
