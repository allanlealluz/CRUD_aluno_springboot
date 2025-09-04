package com.senai.CRUD_aluno_springboot.domain.repository;

import com.senai.CRUD_aluno_springboot.domain.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, String> {
}