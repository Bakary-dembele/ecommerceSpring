package com.bakary.ecommerce.controller.exceptionController;

import com.bakary.ecommerce.exception.UserNotfoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class UserExceptionController {

    @ExceptionHandler(value = UserNotfoundException.class)
    public ResponseEntity<Object> exception(UserNotfoundException exception) {
        return  new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }

}
