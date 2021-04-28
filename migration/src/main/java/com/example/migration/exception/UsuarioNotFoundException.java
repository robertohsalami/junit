package com.example.migration.exception;

public class UsuarioNotFoundException extends RuntimeException{

    public UsuarioNotFoundException(long id){
        super("Usuário com o id: " + id + " nao foi encontrado na base de dados");
    }

}
