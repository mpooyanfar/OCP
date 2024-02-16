package com.example.interview.exception;

import com.example.interview.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExcHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> exceptionHandler(Exception e) {
        var response =  new Response(1001,
                "the operation was unsuccessful",
                e.getMessage());
        return ResponseEntity.badRequest().body(response);
    }
}
