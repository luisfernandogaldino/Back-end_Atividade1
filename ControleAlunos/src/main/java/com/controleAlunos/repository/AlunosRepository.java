package com.controleAlunos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controleAlunos.entities.Alunos;

public interface AlunosRepository extends JpaRepository<Alunos, Long> {

}
