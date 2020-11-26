package com.blindando.api.dto.service;

import com.blindando.api.dto.entity.Usuario;
import com.blindando.api.dto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvar(Usuario usuario){
        validarCampos(usuario);
        return usuarioRepository.save(usuario);
    }

    private void validarCampos(Usuario usuario) {
        if(usuario.getEmail() == null || usuario.getNome() == null)
            throw new RuntimeException("Campos Obrigatórios");
    }
}
