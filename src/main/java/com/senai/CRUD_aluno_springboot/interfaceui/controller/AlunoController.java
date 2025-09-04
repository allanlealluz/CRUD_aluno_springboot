package com.senai.CRUD_aluno_springboot.interfaceui.controller;

import com.senai.CRUD_aluno_springboot.domain.entity.Aluno;
import com.senai.CRUD_aluno_springboot.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private final AlunoRepository alunoRepository;

    @Autowired
    public AlunoController(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    // Criar um novo aluno
    @PostMapping
    public Aluno createAluno(@RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    // Listar todos os alunos
    @GetMapping
    public List<Aluno> getAllAlunos() {
        return alunoRepository.findAll();
    }

    // Buscar aluno por ID
    @GetMapping("/{id}")
    public Aluno getAlunoById(@PathVariable Integer id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }

    // Atualizar aluno
    @PutMapping("/{id}")
    public Aluno updateAluno(@PathVariable Integer id, @RequestBody Aluno alunoDetails) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        aluno.setNome(alunoDetails.getNome());
        aluno.setCPF(alunoDetails.getCPF());
        aluno.setEmail(alunoDetails.getEmail());
        aluno.setCurso(alunoDetails.getCurso());

        return alunoRepository.save(aluno);
    }

    // Deletar aluno
    @DeleteMapping("/{id}")
    public void deletarAluno(@PathVariable Integer id){
        alunoRepository.deleteById(id);
    }
}
