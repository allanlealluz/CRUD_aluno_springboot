package com.senai.CRUD_aluno_springboot.domain.repository;

import com.senai.CRUD_aluno_springboot.domain.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, String> {
}