package com.example.migration.service.impl;

import com.example.migration.entity.Usuario;
import com.example.migration.exception.UsuarioNotFoundException;
import com.example.migration.repository.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceImplTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    @Test
    public void findAllTest(){
        List<Usuario> usuariosBase = getUsuarios();

        when(usuarioRepository.findAll()).thenReturn(usuariosBase);

        List<Usuario> usuarios = usuarioService.findAll();

        assertEquals(usuarios.get(0).getNome(), "Roberto");

        verify(usuarioRepository, times(1)).findAll();
    }

    @Test
    public void saveTest(){
        Usuario usuarioSaved = getUsuarios().get(0);

        when(usuarioRepository.save(getUsuario())).thenReturn(usuarioSaved);

        Usuario usuario = usuarioService.save(getUsuario());

        assertEquals(usuario.getCpf(), "23312988820");

        verify(usuarioRepository, times(1)).save(getUsuario());
    }

    @Test
    public void updateUsuarioTest(){
        when(usuarioRepository.findById(1l)).thenReturn(getUsuarios().stream().findFirst());
        when(usuarioRepository.save(getUsuarioUpdated())).thenReturn(getUsuarioUpdated());

        Usuario usuario = usuarioService.updateUsuario(Usuario.builder().nome("Roberto").idade(41l).cpf("11111111122").build(), 1l);

        assertEquals(usuario.getCpf(), "11111111122");

        verify(usuarioRepository, times(1)).findById(1l);
        verify(usuarioRepository,times(1)).save(getUsuarioUpdated());
    }

    private Usuario getUsuarioUpdated() {
        return Usuario.builder()
                .id(1l)
                .nome("Roberto")
                .idade(41l)
                .cpf("11111111122")
                .build();
    }

    private List<Usuario> getUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        Usuario usuario1 = new Usuario();
        usuario1.setId(1l);
        usuario1.setNome("Roberto");
        usuario1.setIdade(41l);
        usuario1.setCpf("23312988820");
        usuarios.add(usuario1);
        return usuarios;
    }

    private Usuario getUsuario(){
        return Usuario.builder()
                .id(1l)
                .nome("Roberto")
                .idade(41l)
                .cpf("23312988820")
                .build();
    }

}
