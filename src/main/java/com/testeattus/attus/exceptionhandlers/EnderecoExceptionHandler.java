package com.testeattus.attus.exceptionhandlers;

import com.testeattus.attus.dto.endereco.exceptions.EnderecoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EnderecoExceptionHandler {

    @ExceptionHandler(EnderecoNotFoundException.class)
    public ResponseEntity<String> handleEnderecoNotFoundException(EnderecoNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

}
