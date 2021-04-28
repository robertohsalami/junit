package com.example.migration.controller;

import com.example.migration.dto.UsuarioRequest;
import com.example.migration.dto.UsuarioResponse;
import com.example.migration.entity.Usuario;
import com.example.migration.mapper.UsuarioMapper;
import com.example.migration.service.UsuarioService;
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
    public List<UsuarioResponse> listAll(){
        return mapper.usuarioToUsuarioResponse(usuarioService.findAll()) ;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioResponse save(@RequestBody UsuarioRequest usuarioRequest){
        Usuario usuario = usuarioService.save(mapper.usuarioRequestToUsuario(usuarioRequest));
        return mapper.usuarioToUsuarioResponse(usuario);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUsuario(@PathVariable long id){
        usuarioService.deleteUsuario(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioResponse updateUsuario(@RequestBody UsuarioRequest usuarioRequest, @PathVariable long id){
        Usuario usuarioUpdate = usuarioService.updateUsuario(mapper.usuarioRequestToUsuario(usuarioRequest), id);
        return mapper.usuarioToUsuarioResponse(usuarioUpdate);
    }

}
