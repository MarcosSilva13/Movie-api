package com.movie.movieapi.controller.exceptions;

import com.movie.movieapi.service.exceptions.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(EntityNotFoundException ex, HttpServletRequest request) {
        StandardError standardError = new StandardError();
        standardError.setTimeStamp(LocalDateTime.now());
        standardError.setStatus(HttpStatus.NOT_FOUND.value());
        standardError.setError("Entity not found");
        standardError.setMessage(ex.getMessage());
        standardError.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
    }
}
