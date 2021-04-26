package com.example.migration.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UsuarioRequest {

    private String nome;

    private Long idade;

    private String cpf;
}
