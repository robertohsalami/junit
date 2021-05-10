package com.example.migration.service;

import com.example.migration.entity.LoginUsuario;
import com.example.migration.repository.LoginUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private LoginUsuarioRepository loginUsuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginUsuario loginUsuario = Optional.ofNullable(loginUsuarioRepository.findByUsername(username))
                .orElseThrow(()->new UsernameNotFoundException("Usuário nao foi encontrado")) ;
        List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
        List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER");

        return new User(loginUsuario.getUsername(), loginUsuario.getPassword(), loginUsuario.isAdmin() ? authorityListAdmin : authorityListUser);
    }
}
