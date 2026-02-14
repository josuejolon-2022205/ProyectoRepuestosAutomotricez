package com.JosueJolon.RepuestosAutomotricez.Exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> validarMapeo(ResourceNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Error", "no se encontro el id"));

    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> validarFormatoJson(HttpMessageNotReadableException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of("Error", "JSON inválido o tipo de dato incorrecto."));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> validarAnotacionesEntidad(MethodArgumentNotValidException e) {

        List<String> mensajes = e.getBindingResult().getFieldErrors().stream().map(err -> err.getDefaultMessage()).toList();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("errores", mensajes));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> validarId(IllegalArgumentException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Error", "el id no existe"));
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<Object> validarFKs(SQLIntegrityConstraintViolationException e){
        return ResponseEntity.badRequest().body(Map.of("Error:", "No existe el id"));
    }

 }
