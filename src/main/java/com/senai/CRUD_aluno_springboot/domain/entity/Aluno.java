package com.senai.CRUD_aluno_springboot.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Aluno extends Usuario {

    private String turma;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
}