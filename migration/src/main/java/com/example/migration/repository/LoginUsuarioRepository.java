package com.example.migration.repository;

import com.example.migration.entity.LoginUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginUsuarioRepository extends JpaRepository<LoginUsuario, Long> {
    LoginUsuario findByUsername(String username);
}
