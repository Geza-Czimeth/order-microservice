package com.melita.order.rest.controller.exception;

import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.logging.Level.SEVERE;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
@Log
public class RestExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity<String> validationException(MethodArgumentNotValidException ex) {
        log.log(SEVERE, "Validation exception: ", ex);

        Map<String, String> errors = new HashMap<>();
        List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();

        allErrors.forEach(error -> {
                    String fieldName = ((FieldError) error).getField();
                    String message = error.getDefaultMessage();
                    errors.put(fieldName, message);
                }
        );
        return new ResponseEntity<>("Validation error: " + errors, BAD_REQUEST);
    }

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity<String> handleException(Exception ex) {
        log.log(SEVERE, "Unexpected exception: ", ex);
        return new ResponseEntity<>("Unknown exception!", INTERNAL_SERVER_ERROR);
    }
}
