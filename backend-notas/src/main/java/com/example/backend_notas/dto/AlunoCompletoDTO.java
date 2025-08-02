package com.example.backend_notas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AlunoCompletoDTO {
    private String nome;
    private List<Double> notas;
    private double frequencia;
}
