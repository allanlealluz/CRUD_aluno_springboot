package com.senai.CRUD_aluno_springboot.repository;

import com.senai.CRUD_aluno_springboot.domain.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

}
