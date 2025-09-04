package com.senai.CRUD_aluno_springboot.interfaceui.controller;



import com.senai.CRUD_aluno_springboot.application.dto.AlunoDTO;
import com.senai.CRUD_aluno_springboot.application.service.AlunoService;
import com.senai.CRUD_aluno_springboot.domain.entity.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    @GetMapping
    public List<AlunoDTO> listarAlunos(){
        return alunoService.listarAlunos();
    }

    @GetMapping("/{id}")
    public AlunoDTO buscarAluno(@PathVariable String id){
        return alunoService.buscarAlunoPorId(id);
    }

    @PostMapping
    public AlunoDTO salvarAluno(@RequestBody AlunoDTO alunoDTO){
        return alunoService.salvarAluno(alunoDTO);
    }

    @PutMapping("/{id}")
    public AlunoDTO editarAluno(@PathVariable String id ,@RequestBody AlunoDTO alunoDTO){
        return alunoService.atualizarAluno(id,alunoDTO);
    }
    @DeleteMapping("/{id}")
    public void deletarAluno(@PathVariable String id){
        alunoService.deletarAluno(id);
    }
}