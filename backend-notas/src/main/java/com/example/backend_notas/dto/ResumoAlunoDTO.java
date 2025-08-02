package com.example.backend_notas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResumoAlunoDTO {
    private String nome;
    private double mediaNotas;
    private double frequencia;
}
