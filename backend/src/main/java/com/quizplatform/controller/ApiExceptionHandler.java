package com.quizplatform.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {
 @ExceptionHandler(IllegalArgumentException.class)
 public ResponseEntity<Map<String,String>> badRequest(IllegalArgumentException ex) { return ResponseEntity.badRequest().body(Map.of("message",ex.getMessage())); }
 @ExceptionHandler(MethodArgumentNotValidException.class)
 public ResponseEntity<Map<String,String>> validation(MethodArgumentNotValidException ex) { return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message","Please provide valid registration/login details.")); }
}
