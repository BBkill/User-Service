package org.aibles.userservice.service.Exception;

import org.springframework.http.HttpStatus;

public class UserEmailInvalidException extends AbstractException{
    public UserEmailInvalidException(){
        super("invalid email", HttpStatus.BAD_REQUEST);
    }
}
