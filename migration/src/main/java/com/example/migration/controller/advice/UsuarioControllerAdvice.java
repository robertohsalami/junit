package com.example.migration.controller.advice;

import com.example.migration.exception.UsuarioNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class UsuarioControllerAdvice {

    @ResponseBody
    @ExceptionHandler(UsuarioNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String usuarioNotFoundHandler(UsuarioNotFoundException ex){
        log.error("Usuario nao foi encontrado na base de dados");
        return ex.getMessage();
    }

}
