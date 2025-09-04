package com.senai.CRUD_aluno_springboot.application.dto;



import com.senai.CRUD_aluno_springboot.domain.entity.Aluno;
import com.senai.CRUD_aluno_springboot.domain.entity.Curso;

public record AlunoDTO(
        String nome,
        Long cpf,
        String idCurso,
        String turma
) {
    public static AlunoDTO fromEntity(Aluno aluno){
        if(aluno ==null) return null;
        return new AlunoDTO(
                aluno.getNome(),
                aluno.getCpf(),
                aluno.getCurso() != null ? aluno.getCurso().getId() : null,
                aluno.getTurma()
        );
    }

    public Aluno toEntity (Curso curso){
        Aluno aluno = new Aluno();
        aluno.setNome(this.nome);
        aluno.setCpf(this.cpf);
        aluno.setTipo("Aluno");
        aluno.setTurma(this.turma);
        aluno.setCurso(curso);
        return aluno;
    }
}
