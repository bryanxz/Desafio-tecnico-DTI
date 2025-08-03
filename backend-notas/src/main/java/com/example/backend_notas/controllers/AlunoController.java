package com.example.backend_notas.controllers;



import com.example.backend_notas.dto.EstatisticasFormatadasDTO;
import com.example.backend_notas.model.Aluno;
import com.example.backend_notas.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<Aluno> cadastrarAluno(@RequestBody Aluno aluno) {
        return ResponseEntity.ok(alunoService.cadastrar(aluno));
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> listarAlunos() {
        return ResponseEntity.ok(alunoService.listarTodos());
    }

    @GetMapping("/estatisticas")
    public ResponseEntity<EstatisticasFormatadasDTO> gerarEstatisticasJson() {
        return ResponseEntity.ok(alunoService.gerarEstatisticasJson());
    }
}



