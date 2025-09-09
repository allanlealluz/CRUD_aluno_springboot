package com.senai.CRUD_aluno_springboot.application.service;

import com.senai.CRUD_aluno_springboot.application.dto.ProfessorDTO;
import com.senai.CRUD_aluno_springboot.domain.entity.Curso;
import com.senai.CRUD_aluno_springboot.domain.entity.Professor;
import com.senai.CRUD_aluno_springboot.domain.repository.ProfessorRepository;
import com.senai.CRUD_aluno_springboot.domain.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class ProfessorService {
    @Autowired
    ProfessorRepository professorRepository;
    @Autowired
    CursoRepository cursoRepository;

    @Transactional(readOnly = true)
    public List<ProfessorDTO> listarProfessores() {
        return professorRepository.findAll()
                .stream()
                .map(ProfessorDTO::fromEntity)
                .toList();
    }

    @Transactional(readOnly = true)
    public ProfessorDTO buscarAlunoPorId(String id) {
        return professorRepository.findById(id)
                .map(ProfessorDTO::fromEntity)
                .orElse(null);
    }

    public ProfessorDTO salvarProfessor(ProfessorDTO dto) {
        Curso curso = null;
        Professor entidade = dto.toEntity(curso);
        Professor salvo = professorRepository.save(entidade);
        return ProfessorDTO.fromEntity(salvo);
    }

    public ProfessorDTO atualizarProfessor(String id, ProfessorDTO dto) {
        Optional<Professor> alunoExistenteOpt = professorRepository.findById(id);
        if (alunoExistenteOpt.isEmpty()) return null;

        Professor existente = alunoExistenteOpt.get();
        existente.setNome(dto.nome());
        existente.setCpf(dto.cpf());
        existente.setTipo("Professor");

        Professor atualizado = professorRepository.save(existente);
        return ProfessorDTO.fromEntity(atualizado);
    }

    public void deletarProfessor(String id) {
        professorRepository.deleteById(id);
    }
}
