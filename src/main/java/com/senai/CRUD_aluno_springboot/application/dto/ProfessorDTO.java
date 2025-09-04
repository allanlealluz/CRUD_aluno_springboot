package com.senai.CRUD_aluno_springboot.application.dto;

import com.senai.CRUD_aluno_springboot.domain.entity.Professor;
import com.senai.CRUD_aluno_springboot.domain.entity.Curso;
import com.senai.CRUD_aluno_springboot.domain.entity.Professor;

public record ProfessorDTO (
    String nome,
    Long cpf
) {
        public static ProfessorDTO fromEntity(Professor professor){
            if(professor ==null) return null;
            return new ProfessorDTO(
                    professor.getNome(),
                    professor.getCpf()
            );
        }

        public Professor toEntity (Curso curso){
            Professor professor = new Professor();
            professor.setNome(this.nome);
            professor.setCpf(this.cpf);
            professor.setTipo("Professor");
            return professor;
        }
}
