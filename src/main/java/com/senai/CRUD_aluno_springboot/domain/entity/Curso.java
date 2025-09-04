package com.senai.CRUD_aluno_springboot.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String titulo;

    private int cargaHoraria;

    @OneToMany(mappedBy = "curso")
    private List<Aluno> alunos;
}