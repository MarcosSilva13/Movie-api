package com.movie.movieapi.controller.exceptions;

import com.movie.movieapi.service.exceptions.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<EntityNotFoundExceptionDetails> entityNotFoundException(EntityNotFoundException ex, HttpServletRequest request) {
        var entityNotFoundExceptionDetails = new EntityNotFoundExceptionDetails();
        entityNotFoundExceptionDetails.setTimeStamp(LocalDateTime.now());
        entityNotFoundExceptionDetails.setStatus(HttpStatus.NOT_FOUND.value());
        entityNotFoundExceptionDetails.setError(HttpStatus.NOT_FOUND.name());
        entityNotFoundExceptionDetails.setMessage(ex.getMessage());
        entityNotFoundExceptionDetails.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(entityNotFoundExceptionDetails);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationExceptionDetails> methodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpServletRequest request) {

        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        //Pegando quais foram os campos
        String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(", "));
        //Pegando mensagem dos campos
        String fieldMessage = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));

        var validationExceptionDetails = new ValidationExceptionDetails();
        validationExceptionDetails.setTimeStamp(LocalDateTime.now());
        validationExceptionDetails.setStatus(HttpStatus.BAD_REQUEST.value());
        validationExceptionDetails.setError(HttpStatus.BAD_REQUEST.name());
        validationExceptionDetails.setMessage("Field(s) not filled in correctly");
        validationExceptionDetails.setPath(request.getRequestURI());
        validationExceptionDetails.setFields(fields);
        validationExceptionDetails.setFieldsMessage(fieldMessage);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationExceptionDetails);
    }

}
