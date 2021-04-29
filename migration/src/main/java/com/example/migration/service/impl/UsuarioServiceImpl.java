package com.example.migration.service.impl;

import com.example.migration.entity.Usuario;
import com.example.migration.exception.UsuarioNotFoundException;
import com.example.migration.repository.UsuarioRepository;
import com.example.migration.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        log.info("Buscando todos os usuarios");
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario save(Usuario usuario) {
        log.info("Salvando o usuario: {}. ", usuario);
        return usuarioRepository.save(usuario);
    }

    @Override
    public void deleteUsuario(long id) {
        log.info("Removendo usuario. id: {} ", id );
        usuarioRepository
                .findById(id)
                .orElseThrow(()->
                        new UsuarioNotFoundException(id));
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario updateUsuario(Usuario usuarioRequest, long id) {
        log.info("Atualizando usuario. id: {} ", id);
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
