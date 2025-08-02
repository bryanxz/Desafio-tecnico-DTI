package com.example.backend_notas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstatisticasFormatadasDTO {
    private List<AlunoCompletoDTO> alunos;
    private List<Double> mediaTurmaPorDisciplina;
    private List<String> alunosAcimaDaMedia;
    private List<String> alunosComFrequenciaBaixa;
}
