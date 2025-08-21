package com.senai.CRUD_aluno_springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Aluno {
    @Id
    @GeneratedValue
    private int id;
    private int idAcesso;
    private String CPF;
    private String nome;
    private String email;
    private String curso;

    public Aluno(int id, int idAcesso, String CPF, String nome, String email, String curso) {
        this.id = id;
        this.idAcesso = idAcesso;
        this.CPF = CPF;
        this.nome = nome;
        this.email = email;
        this.curso = curso;
    }


}