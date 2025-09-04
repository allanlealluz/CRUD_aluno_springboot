package com.senai.CRUD_aluno_springboot.interfaceui.controller;

import com.senai.CRUD_aluno_springboot.application.dto.ProfessorDTO;
import com.senai.CRUD_aluno_springboot.application.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    ProfessorService professorService;

    @GetMapping
    public List<ProfessorDTO> listarProfessores(){
        return professorService.listarProfessores();
    }

    @GetMapping("/{id}")
    public ProfessorDTO buscarAluno(@PathVariable String id){
        return professorService.buscarAlunoPorId(id);
    }

    @PostMapping
    public ProfessorDTO salvarProfessor(@RequestBody ProfessorDTO professorDTO){
        return professorService.salvarProfessor(professorDTO);
    }

    @PutMapping("/{id}")
    public ProfessorDTO editarProfessor(@PathVariable String id , @RequestBody ProfessorDTO professorDTO){
        return professorService.atualizarProfessor(id,professorDTO);
    }
    @DeleteMapping("/{id}")
    public void deletararProfessor(@PathVariable String id){
        professorService.deletarProfessor(id);
    }
}
