package com.controleAlunos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controleAlunos.entities.Alunos;
import com.controleAlunos.repository.AlunosRepository;

@Service
public class AlunosService {

	private final AlunosRepository alunosRepository;

	@Autowired
	public AlunosService(AlunosRepository alunosRepository) {
		this. alunosRepository = alunosRepository;
	}
	public List<Alunos> buscaTodosAlunos(){
		return alunosRepository.findAll();
	}
	public Alunos buscaAlunosId(Long id) {
		Optional <Alunos> Alunos = alunosRepository.findById(id);
		return Alunos.orElse(null);
	}
	public Alunos salvaAlunos(Alunos Alunos) {
		return alunosRepository.save(Alunos);
	}
	public Alunos alterarAlunos(Long id, Alunos alterarAlunos) {
		Optional <Alunos> existeAlunos = alunosRepository.findById(id);
		if(existeAlunos.isPresent()) {
			alterarAlunos.setIdAluno(id);
			return alunosRepository.save(alterarAlunos);
		}
		return null;
	}
	public boolean apagarAlunos(Long id) {
		Optional <Alunos> existeAlunos = alunosRepository.findById(id);
		if (existeAlunos.isPresent()) {
			alunosRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
