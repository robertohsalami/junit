package com.example.migration.mapper;

import com.example.migration.dto.UsuarioRequest;
import com.example.migration.dto.UsuarioResponse;
import com.example.migration.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario usuarioRequestToUsuario(UsuarioRequest usuarioRequest){
        return Usuario.builder()
                .nome(usuarioRequest.getNome())
                .idade(usuarioRequest.getIdade())
                .cpf(usuarioRequest.getCpf())
                .build();
    }

    public UsuarioResponse usuarioToUsuarioResponse(Usuario usuario){
        return UsuarioResponse.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .idade(usuario.getIdade())
                .cpf(usuario.getCpf())
                .build();
    }

}
