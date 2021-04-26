package com.example.migration.controller;

import com.example.migration.dto.UsuarioRequest;
import com.example.migration.dto.UsuarioResponse;
import com.example.migration.entity.Usuario;
import com.example.migration.mapper.UsuarioMapper;
import com.example.migration.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioMapper mapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> listAll(){
        return usuarioService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioResponse save(@RequestBody UsuarioRequest usuarioRequest){
        Usuario usuario = usuarioService.save(mapper.usuarioRequestToUsuario(usuarioRequest));
        return mapper.usuarioToUsuarioResponse(usuario);
    }

}
