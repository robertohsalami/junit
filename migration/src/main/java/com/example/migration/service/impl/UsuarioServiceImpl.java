package com.example.migration.service.impl;

import com.example.migration.entity.Usuario;
import com.example.migration.exception.UsuarioNotFoundException;
import com.example.migration.repository.UsuarioRepository;
import com.example.migration.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void deleteUsuario(long id) {
        usuarioRepository
                .findById(id)
                .orElseThrow(()-> new UsuarioNotFoundException(id));
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario updateUsuario(Usuario usuarioRequest, long id) {
        return usuarioRepository
                .findById(id)
                .map(usuarioUpdate-> {
                    usuarioUpdate.setNome(usuarioRequest.getNome());
                    usuarioUpdate.setIdade(usuarioRequest.getIdade());
                    usuarioUpdate.setCpf(usuarioRequest.getCpf());
                    return usuarioRepository.save(usuarioUpdate);
                })
                .orElseThrow(()-> new UsuarioNotFoundException(id));
    }

}
