package com.senai.CRUD_aluno_springboot.application.dto;

import com.senai.CRUD_aluno_springboot.domain.entity.Professor;
import com.senai.CRUD_aluno_springboot.domain.entity.Curso;
import com.senai.CRUD_aluno_springboot.domain.entity.Professor;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

public record ProfessorDTO(
        String id,
        String nome,
        Long cpf,
        List<String> turmas,
        List<String> disciplinas
) {
    public static ProfessorDTO fromEntity(Professor professor) {
        if (professor == null) return null;
        return new ProfessorDTO(
                professor.getId(),
                professor.getNome(),
                professor.getCpf(),
                professor.getTurmas() != null ? professor.getTurmas() : List.of(),
                professor.getDisciplinas() != null ? professor.getDisciplinas() : List.of()
        );
    }

    public Professor toEntity() {
        Professor p = new Professor();
        p.setNome(this.nome);
        p.setCpf(this.cpf);
        p.setTipo("Professor");
        p.setTurmas(this.turmas != null ? new ArrayList<>(this.turmas) : new ArrayList<>());
        p.setDisciplinas(this.disciplinas != null ? new ArrayList<>(this.disciplinas) : new ArrayList<>());
        return p;
    }
}