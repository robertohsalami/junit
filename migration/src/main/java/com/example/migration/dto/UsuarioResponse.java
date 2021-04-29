package com.example.migration.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@Builder
@ToString
public class UsuarioResponse {

    private Long id;

    private String nome;

    private Long idade;

    private String cpf;

}
