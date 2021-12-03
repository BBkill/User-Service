package org.aibles.userservice.service.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UserAldreadyExited extends RuntimeException{
    public UserAldreadyExited(String message){super(message);}
}
