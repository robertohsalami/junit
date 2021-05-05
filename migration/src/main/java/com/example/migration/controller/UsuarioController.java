package com.example.migration.controller;

import com.example.migration.dto.UsuarioRequest;
import com.example.migration.dto.UsuarioResponse;
import com.example.migration.entity.Usuario;
import com.example.migration.mapper.UsuarioMapper;
import com.example.migration.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
@Slf4j
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioMapper mapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioResponse> listAll(){
        List<UsuarioResponse> usuarioResponses = mapper.usuarioToUsuarioResponse(usuarioService.findAll());
        log.info("Busca de todos os usuarios realizado com sucesso!");
        return  usuarioResponses;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioResponse save(@RequestBody UsuarioRequest usuarioRequest){
        Usuario usuario = usuarioService.save(mapper.usuarioRequestToUsuario(usuarioRequest));
        UsuarioResponse usuarioResponse = mapper.usuarioToUsuarioResponse(usuario);
        log.info("Usuario salvo com sucesso! {} ", usuarioResponse);
        return usuarioResponse;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteUsuario(@PathVariable long id){
        usuarioService.deleteUsuario(id);
        log.info("Usuario id: {} removido da base de dados com sucesso!", id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioResponse updateUsuario(@RequestBody UsuarioRequest usuarioRequest, @PathVariable long id){
        Usuario usuarioUpdate = usuarioService.updateUsuario(mapper.usuarioRequestToUsuario(usuarioRequest), id);
        UsuarioResponse usuarioResponse = mapper.usuarioToUsuarioResponse(usuarioUpdate);
        log.info("Usuario: {}, atualizado com sucesso!", usuarioResponse);
        return usuarioResponse;
    }

}
