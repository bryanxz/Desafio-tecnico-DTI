package com.example.backend_notas.model;

import java.util.List;
import lombok.Data;


@Data
public class Aluno {
    private Long id;
    private String nome;
    private List<Double> notas;
    private int frequencia;
}


