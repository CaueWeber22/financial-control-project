package com.fcproject.exception.userExceptions;

import com.fcproject.exception.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class UserResponseHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotAllFieldsFilledException.class)
    public final ResponseEntity<ExceptionResponse> handleNotAllFieldsFilledException(NotAllFieldsFilledException ex, WebRequest request) {
        ExceptionResponse exResponse = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false)
        );

        return new ResponseEntity<>(exResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotAllFieldsFilledException.class)
    public final ResponseEntity<ExceptionResponse> handleUserAlreadyExistsException(UserAlreadyExistsException ex, HttpStatus status, WebRequest request) {
        ExceptionResponse exResponse = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false)
        );

        return new ResponseEntity<>(exResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotAllFieldsFilledException.class)
    public final ResponseEntity<ExceptionResponse> handleUserAlreadyExistsException(UserNotFound ex, HttpStatus status, WebRequest request) {
        ExceptionResponse exResponse = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false)
        );

        return new ResponseEntity<>(exResponse, HttpStatus.BAD_REQUEST);
    }
}
