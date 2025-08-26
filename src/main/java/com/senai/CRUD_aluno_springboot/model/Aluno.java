package com.senai.CRUD_aluno_springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int idAcesso;

    @Column(nullable = false, length = 14)
    private String CPF;

    @NotBlank(message = "O nome do aluno não pode estar vazio")
    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 100)
    private String email;

    @Column(length = 50)
    private String curso;
}
