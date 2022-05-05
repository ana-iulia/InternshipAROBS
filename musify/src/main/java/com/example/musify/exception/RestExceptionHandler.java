package com.example.musify.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity<Object> handleIllegal(IllegalArgumentException ex) {
        UUID errorId = UUID.randomUUID();
        List<String> errors = new ArrayList<>();
        errors.add(ex.getMessage());
        ApiError apiError = new ApiError(BAD_REQUEST, errors);
        apiError.setErrorId(errorId);
        logger.error("Illegal argument: {}", errorId, ex);
        return new ResponseEntity<>(apiError, BAD_REQUEST);

    }

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleNotFoundEntity(EntityNotFoundException ex) {
        UUID errorId = UUID.randomUUID();
        List<String> errors = new ArrayList<>();
        errors.add(ex.getMessage());
        ApiError apiError = new ApiError(NOT_FOUND, errors);
        logger.error("Entity not found: {}", errorId, ex);
        return new ResponseEntity<>(apiError, NOT_FOUND);

    }

    @ExceptionHandler(UnauthorizedException.class)
    protected ResponseEntity<Object> handleUnauthorizedException(UnauthorizedException ex) {
        UUID errorId = UUID.randomUUID();
        List<String> errors = new ArrayList<>();
        errors.add(ex.getMessage());
        ApiError apiError = new ApiError(UNAUTHORIZED, errors);
        logger.error("UNAUTHORIZED: {}", errorId, ex);
        return new ResponseEntity<>(apiError, UNAUTHORIZED);
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errorMessages = ex.getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();
        ApiError apiError = new ApiError(BAD_REQUEST, errorMessages);
        logger.error("Illegal argument: ", ex);
        return new ResponseEntity<>(apiError, BAD_REQUEST);
    }

}
