package com.bookstore.bookstore.exception;


import com.bookstore.bookstore.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){

        HashMap<Object, Object> response = new HashMap<>();

        ;methodArgumentNotValidException.getAllErrors().forEach((errors) -> {
            String fieldName = ((FieldError) errors).getField();
            String message = errors.getDefaultMessage();
            response.put(fieldName, message);
        });

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<?> handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException sqlIntegrityConstraintViolationException){
        HashMap<Object, Object> response = new HashMap<>();

         response.put("bookCode", "Please enter unique book code");

         return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<?> handleBookNotFoundException(BookNotFoundException bookNotFoundException){
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST, bookNotFoundException.getMessage());

        return new ResponseEntity<>(errorMessage, errorMessage.getHttpStatus());
    }


}
