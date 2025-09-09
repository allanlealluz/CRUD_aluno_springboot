package com.senai.CRUD_aluno_springboot.interfaceui.controller;

import com.senai.CRUD_aluno_springboot.application.dto.ProfessorDTO;
import com.senai.CRUD_aluno_springboot.application.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/professor")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    public List<ProfessorDTO> listarProfessores() {
        return professorService.listarProfessores();
    }

    @GetMapping("/{id}")
    public ProfessorDTO buscarProfessor(@PathVariable String id) {
        return professorService.buscarProfessorPorId(id);
    }

    @PostMapping
    public ProfessorDTO salvarProfessor(@RequestBody ProfessorDTO dto) {
        return professorService.salvarProfessor(dto);
    }

    @PutMapping("/{id}")
    public ProfessorDTO atualizarProfessor(@PathVariable String id, @RequestBody ProfessorDTO dto) {
        return professorService.atualizarProfessor(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletarProfessor(@PathVariable String id) {
        professorService.deletarProfessor(id);
    }
}
