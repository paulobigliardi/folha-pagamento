package br.empresa.folha.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
     @ExceptionHandler
    public ResponseEntity<List<String>> dispararMensagem(MethodArgumentNotValidException ex) {
       List<String> erros = ex.getBindingResult().getFieldErrors()
        .stream()
        .map(FieldError::getDefaultMessage)
        .toList();
       return ResponseEntity.status(400).body(erros); 
        }
}
