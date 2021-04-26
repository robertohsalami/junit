package com.example.migration.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UsuarioResponse {

    private Long id;

    private String nome;

    private Long idade;

    private String cpf;

}
