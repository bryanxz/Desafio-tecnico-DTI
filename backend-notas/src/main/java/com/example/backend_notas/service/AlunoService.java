package com.example.backend_notas.service;

import com.example.backend_notas.dto.AlunoCompletoDTO;
import com.example.backend_notas.dto.EstatisticasFormatadasDTO;
import com.example.backend_notas.model.Aluno;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class AlunoService {

    private final List<Aluno> alunos = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong();

    public Aluno cadastrar(Aluno aluno) {
        aluno.setId(idGenerator.incrementAndGet());
        alunos.add(aluno);
        return aluno;
    }

    public List<Aluno> listarTodos() {
        return alunos;
    }

    public EstatisticasFormatadasDTO gerarEstatisticasJson() {
        if (alunos.isEmpty()) {
            return new EstatisticasFormatadasDTO(List.of(), List.of(), List.of(), List.of());
        }

        int disciplinas = 5;

        List<Double> mediaPorDisciplina = new ArrayList<>();
        for (int i = 0; i < disciplinas; i++) {
            int index = i;
            double media = alunos.stream()
                    .mapToDouble(a -> a.getNotas().get(index))
                    .average()
                    .orElse(0);
            mediaPorDisciplina.add(media);
        }

        double mediaGeral = alunos.stream()
                .mapToDouble(a -> a.getNotas().stream().mapToDouble(Double::doubleValue).average().orElse(0))
                .average()
                .orElse(0);

        List<AlunoCompletoDTO> alunosDTO = new ArrayList<>();
        List<String> acimaMedia = new ArrayList<>();
        List<String> baixaFrequencia = new ArrayList<>();

        for (Aluno aluno : alunos) {
            double mediaAluno = aluno.getNotas().stream().mapToDouble(Double::doubleValue).average().orElse(0);
            alunosDTO.add(new AlunoCompletoDTO(aluno.getNome(), aluno.getNotas(), aluno.getFrequencia()));

            if (mediaAluno > mediaGeral) {
                acimaMedia.add(aluno.getNome());
            }

            if (aluno.getFrequencia() < 75.0) {
                baixaFrequencia.add(aluno.getNome());
            }
        }

        return new EstatisticasFormatadasDTO(alunosDTO, mediaPorDisciplina, acimaMedia, baixaFrequencia);
    }


}